package de.mathema.simpletest;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("fastTest")
public class MultipleAssertionsTest {
	@Test
	public void timeoutSoft() {
		assertTimeout(ofMillis(50), () -> { Thread.sleep(200));
	}

	@Test
	public void timeoutHard() {
		assertTimeoutPreemptively(ofMillis(100), () -> Thread.sleep(200));
	}

}
