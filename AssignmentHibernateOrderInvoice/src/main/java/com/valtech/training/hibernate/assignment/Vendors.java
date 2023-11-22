package com.valtech.training.hibernate.assignment;

import java.util.HashSet;
import java.util.Objects;
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


@Entity
public class Vendors {

	@Id
	private int id;
	private String name;
	
	@OneToOne(targetEntity = Address.class, cascade = {CascadeType.MERGE,CascadeType.REMOVE},
			fetch = FetchType.EAGER)
	@JoinColumn(name="address_id",referencedColumnName = "id")
	private Address address;
	
	//no cascade because account and customer are two independent guys
	@ManyToMany(targetEntity = Items.class, fetch = FetchType.LAZY)
	@JoinTable(name = "item_vendor",joinColumns = @JoinColumn(name = "vendor_id",referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name="item_id",referencedColumnName = "id"))
	private Set<Items> items;
	
	public Vendors(int id,String name) {
		this.id = id;
		this.name = name;
	}

	public Vendors() {
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
	
	@Override
	public int hashCode() {
		return Objects.hash(address, id, items, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendors other = (Vendors) obj;
		return Objects.equals(address, other.address) && id == other.id && Objects.equals(items, other.items)
				&& Objects.equals(name, other.name);
	}

	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
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


}
