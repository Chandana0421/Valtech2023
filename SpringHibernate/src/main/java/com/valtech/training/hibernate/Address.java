package com.valtech.training.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Address {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String street;
	private String city;
	private int zipCode; // underlying column will be zip_code. Using @column you can customize it
	
	@OneToOne(targetEntity = Customer.class,cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	//only one child! ref->pk column of the parent, name-> column name in the child
	@JoinColumn(name="customer_id",referencedColumnName = "id")
	private Customer customer;


	
	public Address() {
	}

	public Address(String street, String city, int zipCode) {
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
}
