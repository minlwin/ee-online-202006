package com.jdc.auth;

import javax.annotation.security.DeclareRoles;
import javax.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;

@DeclareRoles({"Admin", "Member"})
@FormAuthenticationMechanismDefinition(
			loginToContinue = @LoginToContinue(
					loginPage = "/login.xhtml",
					errorPage = "/login.xhtml?error=1"
			))
public class AppConfig {

}
