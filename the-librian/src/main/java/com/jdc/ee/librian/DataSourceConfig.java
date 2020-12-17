package com.jdc.ee.librian;

import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.context.ApplicationScoped;

@DataSourceDefinition(
		name = "java:app/libraryDB",
		url = "jdbc:hsqldb:mem:libraryDB",
		user = "sa",
		password = "sa",
		className = "org.hsqldb.jdbc.JDBCDataSource"
)
@ApplicationScoped
public class DataSourceConfig {

}
