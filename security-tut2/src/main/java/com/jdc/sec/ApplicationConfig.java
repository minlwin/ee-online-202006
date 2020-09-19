package com.jdc.sec;

import javax.annotation.security.DeclareRoles;
import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

@DataSourceDefinition(
	name = "java:app/SecurityDB",
	url = "jdbc:hsqldb:mem:SecurityDB", 
	user = "sa", 
	password = "sa", 
	className = "org.hsqldb.jdbc.JDBCPool")
@DatabaseIdentityStoreDefinition(
		dataSourceLookup = "java:app/SecurityDB",
		callerQuery = "select password from account where login_id = ?",
		groupsQuery = "select role from account where login_id = ?"
)
@FormAuthenticationMechanismDefinition(
		loginToContinue = @LoginToContinue(
				loginPage = "/login.xhtml",
				errorPage = "/login-error.xhtml"
		)
)
@DeclareRoles({"Admin", "Member"})
@FacesConfig
@ApplicationScoped
public class ApplicationConfig {
}
