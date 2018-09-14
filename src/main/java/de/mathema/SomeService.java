package de.mathema;

public class SomeService {
	private SomeInternalService internalService = new SomeInternalService();

	public String greet(String name) {
		return internalService.getGreeting() + " " + name;
	}

	public String doSomethingLong() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "done";
	}
}
