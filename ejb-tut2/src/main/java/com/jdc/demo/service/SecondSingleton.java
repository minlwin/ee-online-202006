package com.jdc.demo.service;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@LocalBean
@Singleton
public class SecondSingleton {

	@PostConstruct
	private void init() {
		System.out.println("Second Singleton Bean is Initialized");
	}
}
