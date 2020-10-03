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
		url = "jdbc:postgresql://localhost:5432/shops",
		user = "shops",
		password = "shops",
		className = "org.postgresql.ds.PGSimpleDataSource"
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
