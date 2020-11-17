package com.jdc.products;

import javax.annotation.sql.DataSourceDefinition;
import javax.enterprise.context.ApplicationScoped;

@DataSourceDefinition(
		name = "java:app/productDB",
		url = "jdbc:hsqldb:mem:productDB",
		user = "sa",
		password = "sa",
		className = "org.hsqldb.jdbc.JDBCDataSource"
)
@ApplicationScoped
public class DatabaseSetting {

}
