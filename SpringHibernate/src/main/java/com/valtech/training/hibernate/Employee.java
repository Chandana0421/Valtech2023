package com.valtech.training.hibernate;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
@Entity
public class Employee {
	
	//saying id is out primary key, wherever you use the annotation @Id, it'll become primary key
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	//adds auto-increment to mysql table, ONLY WORKS WITH HYBERNATE/Postgress
	
//	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	//2 query to understand what is the current seed
	private int id;
	private String name;
	
	//converts gibberish date string to date, LocalDate is not supported by this version of hibernate, works on hibernate-6
	@Basic @Temporal(TemporalType.DATE)
	private Date dob;
	private float salary;
	private char gender;
	private boolean active;
	
	//not for user manipulation, when hibernate stores obj for the first time it'll store version as, for every update the version will go on incrementing.
	@Version
	private int version;
	
	public Employee() {
		
	}
	public Employee(String name, Date dob, float salary, char gender, boolean active) {
		super();
		this.name = name;
		this.dob = dob;
		this.salary = salary;
		this.gender = gender;
		this.active = active;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", salary=" + salary + ", gender=" + gender
				+ ", active=" + active + ", version=" + version + "]";
	}
}
