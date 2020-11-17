package com.jdc.demo.service;

import javax.ejb.Local;

@Local
public interface HelloLocal {

	String sayHello();
}
