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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.valtech.training.hibernate.Account;
import com.valtech.training.hibernate.Customer;

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
	
	@ManyToMany(targetEntity = Items.class, fetch = FetchType.LAZY)
	//join columns -> this table to join table, inverseJoin -> this table to join table
	@JoinTable(name = "Item_vendor",joinColumns = @JoinColumn(name = "vendor_id",referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name="item_id",referencedColumnName = "id"))
	private Set<Items> items;
	
	
	
	@Override
	public String toString() {
		return "Vendors [id=" + id + ", name=" + name + ", address=" + address + ", items=" + items + "]";
	}

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
	
	public void addItems(Items it) {
		if(getItems()==null) {
			setItems(new HashSet<Items>());
		}
		getItems().add(it);
		
		if(it.getVendors()==null) {
			it.setVendors(new HashSet<Vendors>());
		}
		it.getVendors().add(this);
	}

	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}


}
