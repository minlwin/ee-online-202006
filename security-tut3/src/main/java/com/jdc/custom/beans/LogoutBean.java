package com.jdc.custom.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LogoutBean {

	@Inject
	private ExternalContext externalContext;
	
	public String logout() {
		externalContext.invalidateSession();
		return "/index?faces-redirect=true";
	}
}
