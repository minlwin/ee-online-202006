package com.jdc.sec.model.interceptors;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.jdc.sec.AppCommonException;

@ErrorHandler
@Interceptor
public class ErrorHandlerInterceeptor {

	public ErrorHandlerInterceeptor() {
		// TODO Auto-generated constructor stub
	}

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		
		try {
			return ic.proceed();
		} catch (AppCommonException e) {
			FacesMessage message = new FacesMessage(null, e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		
		return null;
	}

}
