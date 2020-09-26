package com.jdc.online.shop.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LogoutBean {

	@Inject
	private ExternalContext context;
	
	public String logout() {
		context.invalidateSession();
		return "/index.xhtml?faces-redirect=true";
	}
}
