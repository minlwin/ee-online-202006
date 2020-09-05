package com.jdc.cdi;

public class SuperHelloService implements HelloServiceInf{

	@Override
	public String sayHello(String name) {
		return String.format("Super Hello %s!", name);
	}

}
