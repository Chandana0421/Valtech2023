package com.valtech.training.springbootassignment.models;

import java.util.Collections;
import java.util.Set;

import com.valtech.training.springbootassignment.entities.Department;
import com.valtech.training.springbootassignment.entities.Employee;

public class DepartmentModel {
	private int id;
	private String name, location;
	private Set<Employee> employees;
	public DepartmentModel() {
	}
	public DepartmentModel(Department dept) {
		this.id = dept.getId();
		this.name = dept.getName();
		this.location = dept.getLocation();
		this.employees = dept.getEmployees();
	}
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public Department getDepartment(Department dept) {
		return new Department(id,name,location,employees);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}	
}
