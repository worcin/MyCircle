package de.mathema.parameterized;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;

import de.mathema.SomeEnum;

public class EnumsTest {
	@ParameterizedTest
	@EnumSource(value = SomeEnum.class, mode = Mode.EXCLUDE, names = "C")
	void testWithEnumSource(SomeEnum someEnum) {
		assertTrue(someEnum.isNotC());
	}
}
