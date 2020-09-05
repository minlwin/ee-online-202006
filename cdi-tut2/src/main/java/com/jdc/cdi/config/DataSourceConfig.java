package com.jdc.cdi.config;

import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.context.ApplicationScoped;

@DataSourceDefinition(
		name = "java:app/stateDB",
		url = "jdbc:hsqldb:mem:stateDB",
		user = "sa",
		password = "sa",
		className = "org.hsqldb.jdbc.JDBCPool"
)
@ApplicationScoped
public class DataSourceConfig {

}
