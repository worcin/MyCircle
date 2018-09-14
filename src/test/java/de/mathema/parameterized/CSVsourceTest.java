package de.mathema.parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CSVsourceTest {

	@ParameterizedTest
	@CsvFileSource(resources = "testdata.csv")
	public void testSum(int first, int second, int expectedSum) {
		assertEquals(expectedSum, first + second);
	}
}
