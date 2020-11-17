package com.jdc.demo.service;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class HelloSessionBean implements HelloLocal, HelloRemote{

	@Override
	public String sayHello() {
		return "Message from EJB";
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Hello Session Bean is Initialized");
	}

}
