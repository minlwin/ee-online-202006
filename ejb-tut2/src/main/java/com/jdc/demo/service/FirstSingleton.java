package com.jdc.demo.service;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@LocalBean
@Singleton
@Startup
@DependsOn("SecondSingleton")
public class FirstSingleton {

	private String message;
	
	@PostConstruct
	private void init() {
		message = "Hello from First Singleton";
		System.out.println("First Singleton Bean is Initialized");
	}
	
	public String getMessage() {
		return message;
	}
}
