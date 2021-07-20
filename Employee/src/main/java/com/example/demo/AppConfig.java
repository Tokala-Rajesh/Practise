//package com.example.demo;
//import org.h2.server.web.WebServlet;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//
//import com.example.config.CustomerConfig;
//import com.example.config.EmployeeConfig;
//import com.example.config.InvoiceConfig;

//@EnableAutoConfiguration
//@Configuration
//@Import({EmployeeConfig.class,CustomerConfig.class,InvoiceConfig.class})
//public class AppConfig 
//{
//	//Custom config can be declared here
//	//it helps to look up the h2 database on browser
//	@Bean
//	   ServletRegistrationBean h2servletRegistration(){
//	   ServletRegistrationBean registrationBean = new  ServletRegistrationBean( new WebServlet());
//	    registrationBean.addUrlMappings("/console/*");
//	     return registrationBean;
//	    }
//
//}
package com.example.demo;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import com.example.config.EmployeeConfig;


//import org.h2.server.web.WebServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;




@EnableAutoConfiguration
@Configuration
@PropertySource("classpath:database.properties")
@ComponentScan({"com.example.service"})
@Import({EmployeeConfig.class,})
public class AppConfig {
	Logger logger = LoggerFactory.getLogger(AppConfig.class);
	// Custom config can be declared here.
	// its helps to look up the h2 database on browser
	
//	@Bean
//   ServletRegistrationBean h2servletRegistration(){
//   
//	ServletRegistrationBean registrationBean = new 
//		   ServletRegistrationBean( new WebServlet());
//    registrationBean.addUrlMappings("/console/*");
//     return registrationBean;
//    }
	
	
	@Autowired
	Environment environment;

	private final String URL = "db.url";
	private final String USER = "db.username";
	private final String DRIVER = "db.driver-class-name";
	private final String PASSWORD = "db.password";

	@Bean
	@Autowired
	DataSource dataSource_mydb() {
	logger.debug("in data source");
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty(URL));
		driverManagerDataSource.setUsername(environment.getProperty(USER));
		driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
		driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
		return driverManagerDataSource;
	}
	
  @Bean
@Autowired
@Qualifier("datasource_mydb")
public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    	logger.debug("in data ");
    return new JdbcTemplate(dataSource);
}
}
