package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.dao.EmployeeDaoImpl;
import com.jwt.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDaoImpl employeeDaoImpl;
	
	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.addEmployee(employee);
	}

	@Override
	public String deleteEmpoyee(String name) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.deleteEmpoyee(name);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.updateEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDaoImpl.getAllEmployees();
	}

	@Override
	public Employee getEmployee(String employee) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.getEmployee(employee);
	}

}
