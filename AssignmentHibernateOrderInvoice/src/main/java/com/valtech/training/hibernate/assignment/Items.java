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


@Entity
public class Items {
	@Id
	private int id;
	private String name, description;
	private double unitPrice;

	@ManyToMany(targetEntity = Vendors.class, fetch = FetchType.LAZY, mappedBy = "items")
	private Set<Vendors> vendors;
	public Set<Vendors> getVendors() {
		return vendors;
	}

	public void setVendors(Set<Vendors> vendors) {
		this.vendors = vendors;
	}
	public Items() {
		// TODO Auto-generated constructor stub
	}

	public Items(int id, String name, String description, double unitPrice) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


}
