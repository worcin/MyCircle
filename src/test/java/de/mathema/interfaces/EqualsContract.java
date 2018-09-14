package de.mathema.interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public interface EqualsContract<T> {
	T createValue();
	T createDiffrentValue();

	@Test
	default void equalToSelf() {
		T value = createValue();
		assertEquals(value, value);
	}

	@Test
	default void equalToSame() {
		assertEquals(createValue(), createValue());
	}
	
	@Test
	default void notEqualToNull() {
		assertNotEquals(null, createValue());
	}
	
	@Test
	default void notEqual(){
		assertNotEquals(createDiffrentValue(), createValue());
	}
}
