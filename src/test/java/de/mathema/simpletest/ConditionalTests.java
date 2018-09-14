package de.mathema.simpletest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

@Tag("fastTest")
public class ConditionalTests {

	@Test
	public void onlyWindows() {
		assumeTrue("Windows 9".equals(System.getProperty("os.name")));
		fail("");
	}
	
	@Test
	@EnabledOnOs(OS.WINDOWS)
	public void onlyWindowsAnnotated() {
		fail("");
	}

	@Test
	void testInAllEnvironments() {
		assumingThat("Windows 9".equals(System.getProperty("os.name")),
				() -> fail("")
			);
		assertEquals("a string", "a string");
	}

	@Test
	@EnabledOnJre(JRE.JAVA_11)
	void onlyOnJava8() {
		fail("");
	}

	@RepeatedTest(value = 10, name = "Wiederholung {currentRepetition} von {totalRepetitions}")
	@DisabledIf("Math.random() < 0.314159")
	void withScript() {
		// ...
	}
}
