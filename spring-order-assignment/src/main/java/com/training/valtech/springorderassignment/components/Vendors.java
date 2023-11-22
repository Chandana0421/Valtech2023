package com.training.valtech.springorderassignment.components;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class Vendors {


	private int id;
	private String name;
	private int address_id;
	
	public Vendors(int id,String name,int address_id) {
		this.id = id;
		this.name = name;
		this.address_id = address_id;
	}

	public Vendors() {
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

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address_id, id, name);
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
		return address_id == other.address_id && id == other.id && Objects.equals(name, other.name);
	}


}
