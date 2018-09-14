package de.mathema.mocking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import de.mathema.SomeInternalService;
import de.mathema.SomeService;
import extensions.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockingTest {
	@InjectMocks
	private SomeService sut;
	@Mock
	private SomeInternalService internalService;

	@Test
	public void someTestWithMocking() {
		Mockito.when(internalService.getGreeting()).thenReturn("Hi");

		assertEquals("Hi Nico", sut.greet("Nico"));
	}
}
