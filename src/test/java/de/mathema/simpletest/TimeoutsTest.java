package de.mathema.simpletest;

import static java.time.Duration.ofMillis;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.MethodSource;

import de.mathema.SomeEnum;
import de.mathema.SomeService;
import extensions.TimingExtension;

@ExtendWith(TimingExtension.class)
@Tag("fastTest")
public class TimeoutsTest {
	private SomeService sut = new SomeService();

	@Test
	public void timeoutSoft() {
		assertTimeout(ofMillis(50), () -> sut.doSomethingLong());
	}

	@Test
	public void timeoutHard() {
		assertTimeoutPreemptively(ofMillis(100), () -> sut.doSomethingLong());
	}
	@ParameterizedTest
	@EnumSource(value = SomeEnum.class, mode = Mode.EXCLUDE, names = "C")
	public void testWithEnumSource(SomeEnum someEnum) {
		assertTrue(someEnum.isNotC());
	}

	@ParameterizedTest
	@MethodSource("testDaten")
	public void testSum(int expectedSum, int first, int second) {
		assertEquals(expectedSum, first + second);
	}
	
	private static Stream<Arguments> testDaten() {
		return Stream.of(
				Arguments.of(0, 0, 0),
				Arguments.of(2, 1, 1)
			);
	}

	
	@Test
	public void timeoutHard2() {
		String s1 = new String("asdasd");
		String s2 =  new String("asdasd");
		s1 = s1.intern();
		s2 = s2.intern();
		
		assertTrue(s1 == s2);
	}
}
