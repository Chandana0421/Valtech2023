package com.valtech.training.hibernate.assignment;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.valtech.training.hibernate.Account;

@Entity
@IdClass(OrderDescKey.class)
public class OrderDescription{

	private int quantity;

	@Id
	private int orderId;
	@Id
	//@PrimaryKeyJoinColumn
	private int itemid;


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
	@Override
	public String toString() {
		return "OrderDescription [quantity=" + quantity + "]";
	}
	
}
