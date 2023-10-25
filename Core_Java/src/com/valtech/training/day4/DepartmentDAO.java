package com.valtech.training.day4;

import java.sql.SQLException;
import java.util.List;

import com.valtech.training.day3.Employee;


public interface DepartmentDAO {

	void deleteDepartment(int deptid) throws SQLException;

	void updateDepartment(Department dept) throws SQLException;

	void createDepartment(Department dept) throws SQLException;

	List<Department> getAllDepartments() throws SQLException;
	
	List<Employee> getEmployeeByLocation(String location) throws SQLException;

	Department getDepartment(int deptid) throws SQLException;
	
	public long count() throws SQLException;
	
	List<Employee> getEmployeeByAgeBetween(int age1, int age2) throws SQLException;

	List<Employee> getEmployeeByDepartment(int deptId) throws SQLException;

	List<Employee> getEmployeeSalaryLesserThan(int amount) throws SQLException;

	List<Employee> getEmployeeSalaryGreaterThan(int amount) throws SQLException;
}
