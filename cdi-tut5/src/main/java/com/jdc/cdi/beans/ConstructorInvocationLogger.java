package com.jdc.cdi.beans;

import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class ConstructorInvocationLogger {

	@AroundConstruct
	public void log(InvocationContext ctx) {
		System.out.println("Constructor is calling");
		
		try {
			ctx.proceed();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Constructor is finished");
	}
	
	@AroundInvoke
	public Object invoce(InvocationContext ctx) throws Exception {
		
		System.out.println(ctx.getTarget().getClass().getName());
		System.out.println(ctx.getMethod().getName());
		
		Object result = ctx.proceed();
		
		return result;
	}
}
