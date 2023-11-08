package com.valtech.training.spring.dao;

import java.util.List;

import com.valtech.training.hibernate.Employee;


public interface EmployeeDao {

	Employee saveEmployee(Employee emp);

	Employee updateEmployee(Employee emp);

	Employee loadEmployee(int empId);

	void deleteEmployee(int empId);

	List<Employee> getAllEmployees();

}