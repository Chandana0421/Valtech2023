package com.valtech.training.hibernate.assignment;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customers {

	@Id
	private int id;
	private String name, email, phoneNumber;
	private int age;
	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	@OneToMany(targetEntity = Orders.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customers")
	private Set<Orders> orders;

//
//	@Override
//	public String toString() {
//		return "Customers [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", phoneNumber="
//				+ phoneNumber + ", address=" + address + ", orders=" + orders + "]";
//	}

	public Customers(int id, String name, String email, int age, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}

	public Customers() {
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public void addOrders(Orders or) {
		if (getOrders() == null) {
			setOrders(new HashSet<Orders>());
		}
		getOrders().add(or);
		or.setCustomers(this);
	}

}
