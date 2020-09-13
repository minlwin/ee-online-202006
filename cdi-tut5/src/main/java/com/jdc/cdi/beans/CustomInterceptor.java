package com.jdc.cdi.beans;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Custom
@Interceptor
public class CustomInterceptor {

	public CustomInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		
		System.out.println("Custom Interceptor");
		
		Object result = ic.proceed();
		
		return result;
	}

}
