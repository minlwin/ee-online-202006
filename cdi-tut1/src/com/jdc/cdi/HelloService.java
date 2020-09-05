package com.jdc.cdi;

public class HelloService implements HelloServiceInf {

	@Override
	public String sayHello(String name) {
		return String.format("Hello %s", name);
	}
}
