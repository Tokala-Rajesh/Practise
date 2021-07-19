package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.EmployeeDaoImpl;
import com.example.dto.Employee;

public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeDaoImpl emp;
	
	public void setupDBemp()
	{
		emp.setupDB();
	}

	@Override
	public void createEmpService(String name)
	{
		
		emp.create(name);
	}

	@Override
	public List<Employee> listEmployeeService() 
	{
		// TODO Auto-generated method stub
		return emp.listEmployees();
	}

}
