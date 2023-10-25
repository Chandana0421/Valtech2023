package com.valtech.training.day4;

import java.sql.SQLException;
import java.util.List;

import com.valtech.training.day3.Employee;

public interface EmployeeDAO {

	void deleteEmployee(int i) throws SQLException;

	void updateEmployee(Employee emp) throws SQLException;

	void createEmployee(Employee emp) throws SQLException;

	List<Employee> getAllEmployees() throws SQLException;

	Employee getEmployee(int id) throws SQLException;
	
	public long count() throws SQLException;
	
	public void getListOfEmployeeinEachDepartment() throws SQLException;
	   
	List<Employee> getEmployeeByDeptLocation(String name) throws SQLException;
	 
	List<Employee> getEmployeeByDeptName(String name) throws SQLException;
	 
	List<Employee> getEmployeeAgeBetween(int min,int max) throws SQLException;
	 
	List<Employee> getEmployeeBySeniority(int limitVal) throws SQLException;
	 
	List<Employee> getEmployeeSalaryGreater(int amount) throws SQLException;
	 
	List<Employee> getEmployeeSalaryLesser(int amount) throws SQLException;

}