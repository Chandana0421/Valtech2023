package com.valtech.training.firstspringboot.components;

import java.sql.SQLException;
import java.util.List;


public interface EmployeeDAO {

	void deleteEmployee(int i);

	void updateEmployee(Employee emp);

	void createEmployee(Employee emp);

	List<Employee> getAllEmployees();

	Employee getEmployee(int id);
	
	public long count();
	

}