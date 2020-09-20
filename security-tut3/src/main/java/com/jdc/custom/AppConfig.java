package com.jdc.custom;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;

@DeclareRoles({"Admin", "Member"})
@CustomFormAuthenticationMechanismDefinition(
	loginToContinue = @LoginToContinue(
			loginPage = "/login.xhtml", 
			errorPage = "/login.xhtml?error=1")
)
@FacesConfig(version = Version.JSF_2_3)
@ApplicationScoped
public class AppConfig {

}
