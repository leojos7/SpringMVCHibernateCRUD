package com.jwt.dao;

import java.util.List;

import com.jwt.entity.Employee;

public interface EmployeeDao {

	public String addEmployee(Employee employee);
	
	public String deleteEmpoyee(String name);
	
	public Employee updateEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployee(String employee);
}
