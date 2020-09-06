package com.jdc.sale;

import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.FacesConfig.Version;

@FacesConfig(version = Version.JSF_2_3)
@DataSourceDefinition(
		name = "java:app/SalesDB",
		url = "jdbc:hsqldb:file:/Users/minlwin/databases/sales/SaleDB",
		user = "sa",
		password = "sa",
		className = "org.hsqldb.jdbc.JDBCPool"
)
@ApplicationScoped
public class ApplicationConfig {

}
