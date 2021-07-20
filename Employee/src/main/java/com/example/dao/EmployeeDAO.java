package com.example.dao;

import java.util.List;

import com.example.dto.Employee;

public interface EmployeeDAO
{
	//employee service declaration
	   public Employee getEmployee(Integer id);
	  
	   public List<Employee> listEmployees();
	  
	   public void delete(Integer id);
	  
	   public void update(Integer id, Integer age);
	   
	   public void create(String name,Integer age);

}
