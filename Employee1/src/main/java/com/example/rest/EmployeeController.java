package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.ResourceAccessException;

import com.example.dto.Employee;
import com.example.service.EmployeeService;

public class EmployeeController 
{
	@Autowired
	private EmployeeService empser;
	@RequestMapping(method=RequestMethod.POST,value="/create/{name}")
	public ResponseEntity<Void> create(@PathVariable("name") String name)
	{
		try
		{
			empser.createEmpService(name);
			return ResponseEntity.ok().build();
		
		}
		catch(ResourceAccessException e)
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/displayall")
	public List<Employee> display()
	{
		return empser.listEmployeeService();
	}

}
