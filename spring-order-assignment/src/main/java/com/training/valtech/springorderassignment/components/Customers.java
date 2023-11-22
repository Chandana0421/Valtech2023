package com.training.valtech.springorderassignment.components;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Customers {

	private int id;
	private String name,email,phoneNumber;
	private int age, address_id;

	public Customers(int id, String name, String email, int age, String phoneNumber, int address_id) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.address_id = address_id;
	}

	public Customers() {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address_id, age, email, id, name, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customers other = (Customers) obj;
		return address_id == other.address_id && age == other.age && Objects.equals(email, other.email)
				&& id == other.id && Objects.equals(name, other.name) && Objects.equals(phoneNumber, other.phoneNumber);
	}

}
