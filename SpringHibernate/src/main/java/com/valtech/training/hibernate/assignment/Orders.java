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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.valtech.training.hibernate.Account;
import com.valtech.training.hibernate.Tx;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate date;
	@OneToMany(targetEntity = OrderDescKey.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "orders")
	// fetch is always LAZY for a collection
	private Set<OrderDescKey> orderDesc;
	
	@ManyToOne(targetEntity = Customers.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id",referencedColumnName = "id")
	private Customers customers;

	
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
	
	public Set<OrderDescKey> getOrderDesc() {
		return orderDesc;
	}
	public void setOrderDesc(Set<OrderDescKey> orderDesc) {
		this.orderDesc = orderDesc;
	}
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	public void addOrderDescription(OrderDescKey orderDesc) {
		if (getOrderDesc() == null) {
			setOrderDesc(new HashSet<OrderDescKey>());
		}
		getOrderDesc().add(orderDesc);
		orderDesc.setOrders(this);
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", date=" + date + ", orderDesc=" + orderDesc + ", customers=" + customers + "]";
	}
}
