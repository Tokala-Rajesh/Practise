package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.dto.Employee;

public class EmployeeMapper implements RowMapper<Employee> 
{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Employee emp=new Employee();
		emp.setId(rs.getInt("id"));
		emp.setName(rs.getString("name"));
		// TODO Auto-generated method stub
		return emp;
	}

}
