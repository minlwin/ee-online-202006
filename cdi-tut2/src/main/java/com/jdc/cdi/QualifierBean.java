package com.jdc.cdi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.cdi.qualifiier.Basic;
import com.jdc.cdi.qualifiier.HelloQualifier;
import com.jdc.cdi.qualifiier.Type;
import com.jdc.cdi.services.Hello;

@Named
@RequestScoped
public class QualifierBean {

	@Inject
	@Basic
	private Hello hello;
	
	@Inject
	@HelloQualifier(type = Type.Other)
	private Hello other;
	
	public String getMessage() {
		return hello.sayHello();
	}
	
	public String getOtherMessage() {
		return other.sayHello();
	}
}
