package com.example.dao;

import java.util.List;

import com.example.dto.Employee;

public interface EmployeeDao 
{
	public void create(String name);
	public List<Employee> listEmployees();

}
