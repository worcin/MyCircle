package de.mathema.simpletest;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Duration;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("fastTest")
public class MultipleAssertionsTest {
	@Test
	public void timeoutSoft() {
		assertTimeout(Duration.ofMillis(50), () -> Thread.sleep(200));
	}

	@Test
	public void timeoutHard() {
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> Thread.sleep(200));
	}

}
