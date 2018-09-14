package de.mathema.parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MultipleIntegersTest {

	private static Stream<Arguments> data() {
		return Stream.of(
				Arguments.of(0, "Hallo", new Date()),
				Arguments.of(2, "Hallo2", 1));
	}

	@ParameterizedTest
	@MethodSource("data")
	public void testSum(int expectedSum, int first, int second) {
		assertEquals(expectedSum, first + second);
	}
}
