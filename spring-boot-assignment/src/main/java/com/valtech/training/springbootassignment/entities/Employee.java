package com.valtech.training.springbootassignment.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int seniority, experience, age;
    private String name;
    private int salary;
    @ManyToOne(targetEntity = Department.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name = "department",referencedColumnName = "id")
	private Department department;
   
	public Employee() {
	}


	public Employee(int id, int seniority, int experience, int age, String name, int salary, Department department) {
		this.id = id;
		this.seniority = seniority;
		this.experience = experience;
		this.age = age;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	public Employee(int seniority, int experience, int age, String name, int salary, Department department) {
		this.seniority = seniority;
		this.experience = experience;
		this.age = age;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
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
