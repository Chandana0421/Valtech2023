package com.valtech.training.springbootassignment.services;

import java.util.List;

import com.valtech.training.springbootassignment.entities.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	Employee getEmployee(int employeeId);

	List<Employee> getAllEmployees();
	
	void deleteEmployee(int id);

}