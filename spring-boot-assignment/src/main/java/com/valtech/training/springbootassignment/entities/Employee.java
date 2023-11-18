package com.valtech.training.springbootassignment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int seniority, experience, age;
    private String name;
    @Column(name = "deptid")
    private int deptId;
    private int salary;
    
    public Employee() {
	}

	public Employee(int seniority, int experience, int age, String name, int deptId, int salary) {
		this.seniority = seniority;
		this.experience = experience;
		this.age = age;
		this.name = name;
		this.deptId = deptId;
		this.salary = salary;
	}

	public Employee(int id, int seniority, int experience, int age, String name, int deptId, int salary) {
		super();
		this.id = id;
		this.seniority = seniority;
		this.experience = experience;
		this.age = age;
		this.name = name;
		this.deptId = deptId;
		this.salary = salary;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
}
