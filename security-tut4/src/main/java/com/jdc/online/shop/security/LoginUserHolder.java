package com.jdc.online.shop.security;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.jdc.online.shop.model.entity.Member;

@SessionScoped
public class LoginUserHolder implements Serializable{

	private static final long serialVersionUID = 1L;

	@Named("loginUser")
	@Produces
	private Member loginUser;
	
	@Named
	@Produces
	public String getLoginUserHome() {
		return null != loginUser ? String.format("/%s/home", 
				loginUser.getRole().name().toLowerCase()) : "/index";
	}
	
	@Named
	@Produces
	public String getLoginRole() {
		
		if(null != loginUser) {
			return loginUser.getRole().name();
		}
		
		return null;
	}
	
	public Member getLoginUser() {
		return loginUser;
	}
	
	public void setLoginUser(@Observes Member loginUser) {
		this.loginUser = loginUser;
	}
}
