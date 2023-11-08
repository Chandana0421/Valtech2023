package com.valtech.training.hibernate.assignment;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.valtech.training.hibernate.Account;
import com.valtech.training.hibernate.Tx;

@Entity
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name,description;
	private double unitPrice;
	
//	@OneToMany(targetEntity = OrderDescription.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST,
//			CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "items")
//	// fetch is always LAZY for a collection
//	private Set<OrderDescription> orderDesc;
	
	@ManyToMany(targetEntity = Items.class, fetch = FetchType.LAZY, mappedBy = "items")
	private Set<Vendors> vendors;
	
	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", description=" + description + ", unitPrice=" + unitPrice
				+ ", vendors=" + vendors + "]";
	}
	public Items() {
		// TODO Auto-generated constructor stub
	}
	public Items(String name, String description, double unitPrice) {
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
	
//	public Set<OrderDescription> getOrderDesc() {
//		return orderDesc;
//	}
//	public void setOrderDesc(Set<OrderDescription> orderDesc) {
//		this.orderDesc = orderDesc;
//	}
	public Set<Vendors> getVendors() {
		return vendors;
	}
	public void setVendors(Set<Vendors> vendors) {
		this.vendors = vendors;
	}

}
