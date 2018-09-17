package de.mathema.parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.ValueSource;

import de.mathema.MyClass;
import de.mathema.SomeEnum;

public class ConversionTest {
	@ParameterizedTest
	@ValueSource(strings = { "C" })
	public void testPalindrom(SomeEnum someEnum) {
		assertFalse(someEnum.isNotC());
	}

	@ParameterizedTest
	@ValueSource(strings = "42 Cats")
	void testWithImplicitFallbackArgumentConversion(MyClass myClass) {
		assertEquals("4242 Cats", myClass.getName());
	}

	@ParameterizedTest
	@ValueSource(strings = "42 Cats")
	void testWithConverter(@ConvertWith(ToStringArgumentConverter.class) MyClass myClass) {
		assertEquals("42 Cats 2", myClass.getName());
	}

	static class ToStringArgumentConverter extends SimpleArgumentConverter {
		@Override
		protected Object convert(Object source, Class<?> targetType) {
			assertEquals(MyClass.class, targetType, "Can only convert to MyClass");
			return new MyClass((String) source + " 2");
		}
	}
}
