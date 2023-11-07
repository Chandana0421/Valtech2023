package com.valtech.training.hibernate.assignment;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.valtech.training.hibernate.Account;

@Entity
public class OrderDescription {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
////	private int id;
	private int quantity;

	//keys
	@ManyToOne(targetEntity = Orders.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id",referencedColumnName = "id")
	private Orders orders;
	
	@ManyToOne(targetEntity = Items.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name = "item_id",referencedColumnName = "id")
	private Items items;


	public OrderDescription() {
		// TODO Auto-generated constructor stub
	}

	public OrderDescription(int quantity) {
		this.quantity = quantity;
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
}
