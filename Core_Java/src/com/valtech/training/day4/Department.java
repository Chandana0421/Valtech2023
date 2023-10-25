package com.valtech.training.day4;

import java.util.List;

import com.valtech.training.day3.Employee;

public class Department {
	
	private int id;
//	private List<Employee> empid;
	String name, location;
	
	public Department() {
		// TODO Auto-generated constructor stub
		super();
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

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", location=" + location + "]";
	}

	public Department(int id,String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}

}
