package com.valtech.training.hibernate.assignment;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class OrderDescKey implements Serializable{
	
	/* pk should implement Serializable! 
	 * generate hashcode and equalsto*/
	//keys
	@Id
	@ManyToOne(targetEntity = Orders.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id",referencedColumnName = "id")
	private Orders orders;
	
	@Id
	@ManyToOne(targetEntity = Items.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name = "item_id",referencedColumnName = "id")
	private Items items;
	

	@Override
	public int hashCode() {
		return Objects.hash(items, orders);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDescKey other = (OrderDescKey) obj;
		return Objects.equals(items, other.items) && Objects.equals(orders, other.orders);
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


}
