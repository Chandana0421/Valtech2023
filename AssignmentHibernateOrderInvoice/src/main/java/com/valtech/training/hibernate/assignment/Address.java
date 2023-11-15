package com.valtech.training.hibernate.assignment;

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
	private String city,state;
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	private int zipCode; 
	
	@OneToOne(targetEntity = Customers.class,cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name="customer_id",referencedColumnName = "id")
	private Customers customer;

	@OneToOne(targetEntity = Vendors.class,cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name="vendor_id",referencedColumnName = "id")
	private Vendors vendor;
	
	public Address() {
	}

	public Customers getCustomer() {
		return customer;
	}

	public Address(String street, String city, String state, int zipCode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

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
	public Vendors getVendor() {
		return vendor;
	}

	public void setVendor(Vendors vendor) {
		this.vendor = vendor;
	}

}
