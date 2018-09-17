package de.mathema.simpletest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import de.mathema.SomeService;

@Tag("fastTest")
public class ExceptionHandlingTest {
	private SomeService sut = new SomeService();

	@Test
	public void exceptionHandling() {
		Throwable expected = assertThrows(RuntimeException.class, () -> sut.greet("Nico"));
		assertEquals("Not yet implemented", expected.getMessage());
	}
}
