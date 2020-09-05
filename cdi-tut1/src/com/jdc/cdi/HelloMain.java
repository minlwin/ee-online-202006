package com.jdc.cdi;

public class HelloMain {

	public static void main(String[] args) {
		
		HelloClient client = new HelloClient();
		// how to inject dependency into component
		client.setService(new HelloService());

		client.printHello("Java");
		
		client.setService(new SuperHelloService());
		
		client.printHello("Java");
	}
}
