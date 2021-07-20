package com.example.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.example.dao.EmployeeDAOImpl;
import com.example.dao.EmployeeMapper;
import com.example.dto.Employee;
import com.example.service.EmployeeImpl;
import com.example.service.EmployeeService;
@RestController
public class EmployeeController 
{

	

	@Autowired
	private EmployeeService empservice;
	
	
	
	@GetMapping("/employees")
	
	public List<Employee> display() 
	{
		return empservice.listEmployeeService();
	}
	
	@RequestMapping( method = RequestMethod.GET,  value = "/details/{id}")
	public Employee getEmployee(@PathVariable("id") Integer id)
	{
		return empservice.getEmployeeService(id);
	}
	@RequestMapping( method = RequestMethod.DELETE,  value = "/delete/{id}")
	@ResponseBody
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id)
	{
		try
		{
		empservice.deleteEmployeeService(id);
		return ResponseEntity.ok().build();
		}
		catch(ResourceAccessException e)
		{
			return ResponseEntity.notFound().build();
		}
	}
	@RequestMapping( method = RequestMethod.PUT,  value = "/update/{id} {age}")
	@ResponseBody
	public ResponseEntity<Void> update(@PathVariable("id") Integer id, @PathVariable("age") Integer age)
	{
		try
		{
		empservice.updateEmployeeService(id, age);
		return ResponseEntity.ok().build();
		}
		catch(ResourceAccessException e)
		{
			return ResponseEntity.notFound().build();
		}
	}
	@RequestMapping( method = RequestMethod.POST,  value = "/create/{name} {age}")
	@ResponseBody
	public ResponseEntity<Void> create(@PathVariable("name") String name,@PathVariable("age") Integer age)
	{
		try
		{
		empservice.createEmployeeService(name, age);
		return ResponseEntity.ok().build();
		}
		catch(ResourceAccessException e)
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	

}
