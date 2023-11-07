package com.valtech.training.hibernate.assignment;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Vendors {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToOne(targetEntity = VendorAddress.class, cascade = {CascadeType.MERGE,CascadeType.REMOVE},
			fetch = FetchType.LAZY, mappedBy = "vendor")
	//mapped by -> only on master, saying there's a child column called customer for this class
	
	private VendorAddress address;
	
	public Vendors(String name) {
		this.name = name;
	}

	public Vendors() {
	}


	public VendorAddress getAddress() {
		return address;
	}

	public void setAddress(VendorAddress address) {
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


}
