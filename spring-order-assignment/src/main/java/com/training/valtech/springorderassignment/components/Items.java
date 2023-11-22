package com.training.valtech.springorderassignment.components;


public class Items {
	private int id;
	private String name, description;
	private double unitPrice;

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
