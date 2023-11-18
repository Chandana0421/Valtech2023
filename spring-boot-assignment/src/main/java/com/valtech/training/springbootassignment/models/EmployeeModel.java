package com.valtech.training.springbootassignment.models;

import com.valtech.training.springbootassignment.entities.Employee;

public class EmployeeModel {
	
	private int id;
	private int seniority, experience, age;
    private String name;
    private int deptId;
    private int salary;
	public EmployeeModel() {
	}
	public EmployeeModel(Employee e) {
		this.id = e.getId();
		this.seniority = e.getSeniority();
		this.experience = e.getExperience();
		this.age = e.getAge();
		this.name = e.getName();
		this.deptId = e.getDeptId();
		this.salary = e.getSalary();
	}
	public Employee getEmployee() {
		return new Employee(id,seniority,experience,age,name,deptId,salary);
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
