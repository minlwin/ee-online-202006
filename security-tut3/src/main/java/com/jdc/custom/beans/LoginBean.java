package com.jdc.custom.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;

@Named
@RequestScoped
public class LoginBean {

	@NotEmpty(message = "Please enter Login Id.")
	private String loginId;
	@NotEmpty(message = "Please enter password.")
	private String password;
	
	@Inject
	private ExternalContext context;
	
	@Inject
	private SecurityContext security;
	
	public String login() {
		
		Credential credential = new UsernamePasswordCredential(loginId, password);
		
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		HttpServletResponse response = (HttpServletResponse) context.getResponse();
		
		AuthenticationStatus status = security.authenticate(
				request, response, 
				AuthenticationParameters.withParams().credential(credential));
		
		if(status == AuthenticationStatus.SUCCESS) {
			return context.getRequestHeaderMap().get("referer") + "?faces-redirect=true";
		}
		
		return null;
	}
	
	public String getLoginId() {
		return loginId;
	}
	
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
