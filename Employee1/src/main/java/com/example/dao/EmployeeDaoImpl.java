package com.example.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao 
{
	Logger logger=LoggerFactory.getLogger(EmployeeDaoImpl.class);
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	public void setupDB()
	{
	// jdbcTemplateObject.execute("DROP TABLE IF EXISTS employee1");
	// jdbcTemplateObject.execute("CREATE TABLE employee1 " + "(" + "name VARCHAR(255), age INT, id SERIAL)" );
	// System.out.println("table created");
	jdbcTemplateObject.execute("DROP TABLE IF EXISTS employee1 ");

	jdbcTemplateObject.
	execute("CREATE TABLE employee1"
	+ "(" + "name VARCHAR(255), id SERIAL)");
	}
	@Override
	public void create(String name)
	{
	String SQL="insert into employee1 (name) Values(?)";
	jdbcTemplateObject.update(SQL,name);
	logger.debug("Created record with name="+ name);

	}

	@Override
	public List<Employee> listEmployees()
	{
	String SQL="select * from employee1";
	List<Employee> emps=jdbcTemplateObject.query(SQL, new EmployeeMapper());
	return emps;
	}

	
	}

	

	
	

