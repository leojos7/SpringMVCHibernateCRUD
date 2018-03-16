package com.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.entity.Employee;
import com.jwt.service.EmployeeServiceImpl;


@RestController
@RequestMapping("/FrontController")
public class FrontController {
	
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	@RequestMapping("/test")
	public String welcome() {//Welcome page, non-rest
		return "Welcome to RestTemplate Example.";
	}
	
	@RequestMapping(value = "/get/{name}", method = RequestMethod.GET, produces="application/json")
	public Employee getEmployee(@PathVariable String name) {
		return employeeServiceImpl.getEmployee(name);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces="application/json")
	public List<Employee> getAllEmployees() {
		return employeeServiceImpl.getAllEmployees();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json")
	public String addEmployee(@RequestBody Employee employee) {
		return employeeServiceImpl.addEmployee(employee);
	}
	
	@RequestMapping(value = "/delete/{name}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String name) {
		return employeeServiceImpl.deleteEmpoyee(name);
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeServiceImpl.updateEmployee(employee);
	}

}
