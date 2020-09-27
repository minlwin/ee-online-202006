package com.jdc.online.shop.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Named
@RequestScoped
public class LoginBean {

	@NotEmpty(message = "Please enter email.")
	@Email(message = "Please enter valid email address.")
	private String email;
	@NotEmpty(message = "Please enter password.")
	private String password;
	
	@Inject
	private SecurityContext security;
	@Inject
	private ExternalContext externalContext;

	public String login() {
		
		
		try {
			HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
			HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
			UsernamePasswordCredential credential = new UsernamePasswordCredential(email, password);
			
			AuthenticationStatus status = security.authenticate(request, response, 
					AuthenticationParameters.withParams().credential(credential));
			
			if(status == AuthenticationStatus.SUCCESS) {
				return "/admin/home";
			}
			
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
		}
		
		return null;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
