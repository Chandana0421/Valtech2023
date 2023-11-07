package com.valtech.training.hibernate.assignment;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.valtech.training.hibernate.Tx;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate date;
	@OneToMany(targetEntity = OrderDescription.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "orders")
	// fetch is always LAZY for a collection
	private Set<OrderDescription> orderDesc;
	

	public Orders() {
		// TODO Auto-generated constructor stub
	}
	public Orders(LocalDate date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Set<OrderDescription> getOrderdesc() {
		return orderDesc;
	}
	public void setOrderdesc(Set<OrderDescription> orderDesc) {
		this.orderDesc = orderDesc;
	}
	
	public void addOrderDescription(OrderDescription orderDesc) {
		if (getOrderdesc() == null) {
			setOrderdesc(new HashSet<OrderDescription>());
		}
		getOrderdesc().add(orderDesc);
		orderDesc.setOrders(this);
	}
}
