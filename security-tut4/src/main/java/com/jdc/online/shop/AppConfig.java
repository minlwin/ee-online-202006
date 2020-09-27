package com.jdc.online.shop;

import javax.annotation.security.DeclareRoles;
import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;

@DataSourceDefinition(
		name = "java:app/ShopDB",
		url = "jdbc:hsqldb:meme:ShopDB",
		user = "sa",
		password = "sa",
		className = "org.hsqldb.jdbc.JDBCPool"
)
@DeclareRoles({
	"Admin", "Owner", "Customer"
})

@CustomFormAuthenticationMechanismDefinition(
		loginToContinue = @LoginToContinue(
				loginPage = "/index.xhtml"
		)
)
@FacesConfig(version = Version.JSF_2_3)
@ApplicationScoped
public class AppConfig {

}
