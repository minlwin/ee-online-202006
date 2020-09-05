package com.jdc.cdi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.cdi.services.DiService;

@Named
@RequestScoped
public class DependencyInjectionBean {

	@Inject
	private DiService service;
	
	public String getMessage() {
		return service.getMessage();
	}
}
