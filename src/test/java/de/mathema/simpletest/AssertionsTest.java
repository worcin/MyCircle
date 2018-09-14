package de.mathema.simpletest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("fastTest")
public class AssertionsTest {

	@Test
	@DisplayName("😱")
	public void alwaysOK() {
		assertTrue(true);
	}

	@Test
	@DisplayName("(╯°□°）╯︵ ┻━┻")
	@Disabled("Geht nicht")
	public void alwaysFails() {
		fail("Muss nun");
	}

	@Test
	public void assertWithMessage() {
		assertEquals(1, 1, "Sollten gleich sein");
	}

}
