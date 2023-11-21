package com.valtech.training.springbootassignment.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name, location;
	
	@OneToMany(targetEntity = Employee.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "department")
	// fetch is always LAZY for a collection
	private Set<Employee> employees;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	public Department(int id, String name, String location, Set<Employee> employees) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.employees = employees;
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
	public void addEmployee(Employee emp) {
		if (getEmployees() == null) {
			setEmployees(new HashSet<Employee>());
		}
		getEmployees().add(emp);
		emp.setDepartment(this);
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
