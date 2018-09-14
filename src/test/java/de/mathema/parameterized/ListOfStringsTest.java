package de.mathema.parameterized;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ListOfStringsTest {
	@ParameterizedTest(name = "{index} => String={0}")
	@ValueSource(strings = { "Lagerregal", "Racecar", "Rentner" })
	public void testPalindrom(String string) {
		assertTrue(isPalindrom(string));
	}

	private boolean isPalindrom(String string) {
		String reverseString = new StringBuilder(string).reverse().toString().toLowerCase();
		return string.toLowerCase().equals(reverseString);
	}
}
