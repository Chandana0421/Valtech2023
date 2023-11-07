package com.valtech.training.hibernate.assignment;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.valtech.training.hibernate.Customer;

@Entity
public class VendorAddress {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String street;
	private String city;
	private int zipCode; // underlying column will be zip_code. Using @column you can customize it
	
	@OneToOne(targetEntity = Vendors.class,cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	//only on child! ref->pk column of the parent, name-> column name in the child
	@JoinColumn(name="vendor_id",referencedColumnName = "id")
	private Vendors vendor;


	
	public VendorAddress() {
	}

	public VendorAddress(String street, String city, int zipCode) {
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}

	public Vendors getVendor() {
		return vendor;
	}

	public void setVendor(Vendors vendor) {
		this.vendor = vendor;
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
