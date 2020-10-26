package com.jdc.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.hello.HelloBeanLocal;

@Named
@RequestScoped
public class GreetBean {

	private String name;
	private String message;
	
	@Inject
	private HelloBeanLocal helloBean;
	
	public void greet() {
		message = helloBean.sayHello(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

}
