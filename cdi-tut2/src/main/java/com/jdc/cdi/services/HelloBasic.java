package com.jdc.cdi.services;

import javax.inject.Named;

import com.jdc.cdi.qualifiier.Basic;
import com.jdc.cdi.qualifiier.HelloQualifier;
import com.jdc.cdi.qualifiier.Type;

@Basic
@Named("basic")
@HelloQualifier(type = Type.Basic)
public class HelloBasic implements Hello{

	@Override
	public String sayHello() {
		return "Hello from Basic Implementation";
	}

}
