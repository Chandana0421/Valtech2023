package com.valtech.training.springbootassignment.models;

import java.util.Collections;
import java.util.Set;

import com.valtech.training.springbootassignment.entities.Department;
import com.valtech.training.springbootassignment.entities.Employee;

public class EmployeeModel {
	
	private int id;
	private int seniority, experience, age;
    private String firstName, lastName;
    private int salary;
    private Department department;
	public EmployeeModel() {
	}
	public EmployeeModel(Employee e) {
		this.id = e.getId();
		this.seniority = e.getSeniority();
		this.experience = e.getExperience();
		this.age = e.getAge();
		this.firstName = e.getFirstName();
		this.lastName = e.getLastName();
		this.department = e.getDepartment();
		this.salary = e.getSalary();
	}
	public Employee getEmployee() {
		return new Employee(id,seniority,experience,age,firstName,lastName,salary,department);
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSeniority() {
		return seniority;
	}
	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
