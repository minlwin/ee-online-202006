package com.jdc.sec.model.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class LogoutBean {

	public String logout() {
		
		FacesContext.getCurrentInstance()
			.getExternalContext().invalidateSession();
		
		return "/index.xhtml?faces-redirect=true";
	}
}
