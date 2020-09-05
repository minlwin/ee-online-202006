package com.jdc.cdi.services;

import javax.inject.Named;

import com.jdc.cdi.qualifiier.HelloQualifier;
import com.jdc.cdi.qualifiier.Other;
import com.jdc.cdi.qualifiier.Type;

@Other
@Named("other")
@HelloQualifier(type = Type.Other)
public class HelloOther implements Hello{

	@Override
	public String sayHello() {
		return "Hello form Other Implementation";
	}

}
