package com.jwt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		String status = "FAILURE";
		Session session = sessionFactory.openSession();
	    Transaction transation = session.beginTransaction();
	    session.save(employee);
	    status = "SUCCESS";
		transation.commit();
		session.close();
		return status;
	}

	@Override
	public String deleteEmpoyee(String name) {
		// TODO Auto-generated method stub
		String status = "FAILURE";
		Session session = sessionFactory.openSession();
	    Transaction transation = session.beginTransaction();
	    session.delete(getEmployee(name));
	    status = "DELETED";
		transation.commit();
		session.close();
		return status;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
	    Transaction transation = session.beginTransaction();
	    session.update(employee);
		transation.commit();
		session.close();
		return getEmployee(employee.getFirstName());
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
	    Transaction transation = session.beginTransaction();
	    List<Employee> employees = (List<Employee>)session.createCriteria(Employee.class).list();
		transation.commit();
		session.close();
		return employees;	
	}

	@Override
	public Employee getEmployee(String name) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
	    Transaction transation = session.beginTransaction();
	    Employee employee = (Employee)session.createCriteria(Employee.class)
	    		.add(Restrictions.eq("firstName", name)).uniqueResult();
		transation.commit();
		session.close();
		return employee;
	}



}
