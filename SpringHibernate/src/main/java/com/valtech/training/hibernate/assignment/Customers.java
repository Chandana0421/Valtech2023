package com.valtech.training.hibernate.assignment;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.valtech.training.hibernate.Tx;

@Entity
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name,email;
	private int age, phoneNumber;
	@OneToOne(targetEntity = CustomerAddress.class, cascade = {CascadeType.MERGE,CascadeType.REMOVE},
			fetch = FetchType.LAZY, mappedBy = "customer")
	//mapped by -> only on master, saying there's a child column called customer for this class
	private CustomerAddress address;
	
	@OneToMany(targetEntity = Orders.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "customers")
	// fetch is always LAZY for a collection
	private Set<Orders> orders;
	

	@Override
	public String toString() {
		return "Customers [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", orders=" + orders + "]";
	}

	public Customers(String name, String email, int age, int phoneNumber) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}

	public Customers() {
	}


	public CustomerAddress getAddress() {
		return address;
	}

	public void setAddress(CustomerAddress address) {
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

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
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
