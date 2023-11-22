package com.training.valtech.springorderassignment.components;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class OrderDescription{
	
	private int id;
	private int order_id;
	private int item_id;
	private int quantity;

	public OrderDescription() {
	}

	public OrderDescription(int id, int order_id, int item_id, int quantity) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.item_id = item_id;
		this.quantity = quantity;
	}

	public OrderDescription(int order_id, int item_id, int quantity) {
		super();
		this.order_id = order_id;
		this.item_id = item_id;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, item_id, order_id, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDescription other = (OrderDescription) obj;
		return id == other.id && item_id == other.item_id && order_id == other.order_id && quantity == other.quantity;
	}





}
