package com.valtech.training.hibernate.assignment;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
public class OrderDescription{
	
	@Id
	private int id;
	
	@ManyToOne(targetEntity = Orders.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id",referencedColumnName = "id")
	private Orders orders;

	@ManyToOne(targetEntity = Items.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name = "item_id",referencedColumnName = "id")
	private Items items;
	
	private int quantity;

	public OrderDescription() {
	}

	

	public OrderDescription(int id, Orders orders, Items items, int quantity) {
		this.id = id;
		this.orders = orders;
		this.items = items;
		this.quantity = quantity;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Orders getOrders() {
		return orders;
	}


	public void setOrders(Orders orders) {
		this.orders = orders;
	}


	public Items getItems() {
		return items;
	}


	public void setItems(Items items) {
		this.items = items;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, items, orders, quantity);
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
		return id == other.id && Objects.equals(items, other.items) && Objects.equals(orders, other.orders)
				&& quantity == other.quantity;
	}



}
