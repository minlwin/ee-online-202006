package com.jdc.auth;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class HomeBean {
	
	@EJB
	private BusinessBean bean;
	
	private String user;
	
	public void adminFunction() {
		user = bean.getLoginUsser();
		bean.forAdmin();
	}
	
	public void memberFunction() {
		user = bean.getLoginUsser();
		bean.forMember();
	}

	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "home.xhmtl?faces-redirect=true";
	}
	
	public String getUser() {
		return user;
	}
}
