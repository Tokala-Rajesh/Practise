package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.config.EmployeeConfig;

@EnableAutoConfiguration
@Configuration
@PropertySource("classpath:database1.properties")
@ComponentScan("com.test.rest")
@Import({EmployeeConfig.class,})
public class AppConfig
{
	@Autowired
	Environment env;
	
	private final String URL="db.url";
	private final String USERNAME="db.username";
	private final String PASSWORD="db.password";
	private final String DRIVER="db.driver-class-name";
	
	@Bean
	@Autowired
	DataSource ds_mydb()
	{
		
		DriverManagerDataSource dmds=new DriverManagerDataSource();
		dmds.setUrl(env.getProperty(URL));
		dmds.setUsername(env.getProperty(USERNAME));
		dmds.setPassword(env.getProperty(PASSWORD));
		dmds.setDriverClassName(env.getProperty(DRIVER));
		return dmds;
	}
	
	@Bean
	@Autowired
	@Qualifier("ds_mydb")
	public JdbcTemplate jdbcTeamplate(DataSource ds)
	{
		return new JdbcTemplate(ds);
	}
	

}
