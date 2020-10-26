package com.jdc.hello;

import javax.ejb.Local;

@Local
public interface HelloBeanLocal {

	String sayHello(String name);
}
