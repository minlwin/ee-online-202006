package com.jdc.hello;

import javax.ejb.Stateless;

@Stateless
public class HelloBean implements HelloBeanLocal {


	@Override
	public String sayHello(String name) {
		return String.format("Hello %s!", name);
	}

}
