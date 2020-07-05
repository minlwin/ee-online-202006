package com.jdc.hello.config;

import javax.annotation.sql.DataSourceDefinition;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@DataSourceDefinition(
		name = "java:global/app/ServletDB",
		className = "org.hsqldb.jdbc.JDBCDataSource",
		url = "jdbc:hsqldb:mem:ServletDB",
		user = "sa", password = "sa"
)
@WebServlet(loadOnStartup = 1)
public class DataSourceConfig extends HttpServlet{

	private static final long serialVersionUID = 1L;

}
