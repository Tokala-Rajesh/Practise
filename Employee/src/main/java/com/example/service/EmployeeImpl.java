package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDAOImpl;
import com.example.dto.Employee;

@Service
public class EmployeeImpl implements  EmployeeService
{

	@Autowired
	private EmployeeDAOImpl employeeObj;
    public void setupDB()
    {
		
		employeeObj.setupDB();
	}
	
	@Override
	public void createEmployeeService(String name, Integer age)
	{
		
		employeeObj.create(name, age);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getEmployeeService(Integer id) 
	{
	
		
		// TODO Auto-generated method stub
		return employeeObj.getEmployee(id);
	}

	@Override
	public List<Employee> listEmployeeService() {
		// TODO Auto-generated method stub
		return employeeObj.listEmployees();
	}

	@Override
	public void deleteEmployeeService(Integer id) 
	{
		employeeObj.delete(id);
	
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployeeService(Integer id, Integer age)
	{
		employeeObj.update(id, age);
		// TODO Auto-generated method stub
		
	}
	


}
