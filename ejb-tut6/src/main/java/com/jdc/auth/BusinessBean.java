package com.jdc.auth;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@LocalBean
@Stateless
@PermitAll
public class BusinessBean {
	
	@Resource
	private SessionContext context;
	
	public String getLoginUsser() {
		
		if(context.isCallerInRole("Admin")) {
			System.out.println("Use as Admin");
		}
		
		if(context.isCallerInRole("Member")) {
			System.out.println("Use as Member");
		}

		return context.getCallerPrincipal().getName();
	}
	
	@RolesAllowed("Admin")
	public void forAdmin() {
		System.out.println("Admin Function");
	}
	
	@RolesAllowed({"Member", "Admin"})
	public void forMember() {
		System.out.println("Member Function");
	}
}
