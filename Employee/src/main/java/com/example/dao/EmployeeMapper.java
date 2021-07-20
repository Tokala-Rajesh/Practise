package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
//rowmapper are helping to iterate the data

import com.example.dto.Employee;

public class EmployeeMapper implements RowMapper<Employee> 
{
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		  Employee employee = new Employee();
		  employee.setName(rs.getString("name"));
		  employee.setAge(rs.getInt("age"));
		  employee.setId(rs.getInt("id"));
	      return employee;
		
	}

}
