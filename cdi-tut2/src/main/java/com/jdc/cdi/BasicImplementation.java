package com.jdc.cdi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.cdi.services.Hello;

@Named
@RequestScoped
public class BasicImplementation {

	@Inject
	@Named("other")
	private Hello hello;
	
	public String getMessage() {
		return hello.sayHello();
	}
}
