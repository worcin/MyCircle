package de.mathema;

public class MyClass {
	private String name;

	public String getName() {
		return name;
	}

	public MyClass(String name) {
		super();
		this.name = name;
	}
	
	public static MyClass classForName(String s) {
		return new MyClass("42"+ s);
	}
}
