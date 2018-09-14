package de.mathema;

public enum SomeEnum {
	A(true),B(true),C(false),D(true);
	private boolean notC;

	private SomeEnum(boolean b) {
		notC = b;
	}
	

	public boolean isNotC() {
		return notC;
	}
}
