package com.jdc.jee8.config;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;

@DataSourceDefinition(
		name = "java:global/app/TestDB",
		className = "org.h2.jdbcx.JdbcDataSource",
		url = "jdbc:h2:mem:testDB"
)
@Stateless
public class DataSourceConfig {

}
