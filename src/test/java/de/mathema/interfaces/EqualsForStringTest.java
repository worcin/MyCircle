package de.mathema.interfaces;

public class EqualsForStringTest implements EqualsContract<String> {

	@Override
	public String createValue() {
		return "foo";
	}

	@Override
	public String createDiffrentValue() {
		return "bar";
	}

}
