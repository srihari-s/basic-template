package org.learning.basic_template.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:app.properties")
public class DBConfig {
	
	public static final String PROD_DB_LOCATION = "PROD_DB_LOCATION";
	public static final String PROD_DB_NAME = "PROD_DB_NAME";
	public static final String TEST_DB_LOCATION = "TEST_DB_LOCATION";
	public static final String TEST_DB_NAME = "TEST_DB_NAME";
	
	@Autowired
	Environment env;
	
	@Bean
	@Profile("prod")
	public DataSource getDataSource()
	{
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setJdbcUrl("jdbc:h2:" + env.getProperty(PROD_DB_LOCATION) + env.getProperty(PROD_DB_NAME));
		ds.setUsername("developer");
		ds.setPassword("dev123");
		return ds;
	}
	
	@Bean
	@Profile("test")
	public DataSource getTestDataSource()
	{
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setJdbcUrl("jdbc:h2:" + env.getProperty(TEST_DB_LOCATION) + env.getProperty(TEST_DB_NAME));
		ds.setUsername("developer");
		ds.setPassword("dev123");
		return ds;
	}
	
	public HikariConfig getConfig()
	{
		HikariConfig config = new HikariConfig();

		config.setDataSourceClassName("org.h2.jdbcx.JdbcDataSource");

		config.setConnectionTestQuery("VALUES 1");

		config.addDataSourceProperty("URL", "jdbc:h2:" + env.getProperty(PROD_DB_LOCATION) + env.getProperty(PROD_DB_NAME));

		config.addDataSourceProperty("user", "developer");
		config.addDataSourceProperty("password", "dev123");
		
		return config;

	}
	
	public JdbcTemplate getJdbcTemplate()
	{
		return new JdbcTemplate(getDataSource());
	}
}
