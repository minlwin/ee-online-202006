package com.jdc.sec.model;

import javax.annotation.security.DeclareRoles;
import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;

@DataSourceDefinition(
		name = "java:app/CustomDB",
		className = "org.hsqldb.jdbc.JDBCPool",
		url = "jdbc:hsqldb:mem:CustomDB",
		user = "sa",
		password = "sa"
)
@DeclareRoles({"Admin", "Member"})
@FacesConfig(version = Version.JSF_2_3)
@ApplicationScoped
public class AppConfig {

}
