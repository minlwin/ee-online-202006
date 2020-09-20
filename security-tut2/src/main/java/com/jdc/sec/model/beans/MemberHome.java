package com.jdc.sec.model.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotEmpty;

import com.jdc.sec.model.interceptors.ErrorHandler;
import com.jdc.sec.model.service.UserService;

@Named
@RequestScoped
public class MemberHome {

	@NotEmpty(message = "Please enter password")
	private String password;
	@NotEmpty(message = "Please enter new password")
	private String newPwassword;
	@NotEmpty(message = "Please enter confirm password")
	private String confirmPassword;
	
	@Inject
	private UserService service;

	@ErrorHandler
	public String changePass() {
		
		// change password
		service.changePassword(password, newPwassword, confirmPassword);
		
		// logout
		FacesContext.getCurrentInstance().getExternalContext()
			.invalidateSession();
		
		return "/member/home.xhtml?faces-redirect=true";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPwassword() {
		return newPwassword;
	}

	public void setNewPwassword(String newPwassword) {
		this.newPwassword = newPwassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
