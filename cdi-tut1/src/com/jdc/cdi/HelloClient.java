package com.jdc.cdi;

public class HelloClient {

	private HelloServiceInf service;
	
	public void setService(HelloServiceInf service) {
		this.service = service;
	}
	
	public void printHello(String name) {
		System.out.println(service.sayHello(name));
	}
}
