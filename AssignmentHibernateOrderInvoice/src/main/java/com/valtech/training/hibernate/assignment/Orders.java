package com.valtech.training.hibernate.assignment;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Orders {
	@Id
	
	private int id;
	@Basic @Temporal(TemporalType.DATE)
	private Date date;
	@OneToMany(targetEntity = OrderDescription.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.EAGER, mappedBy = "orders")
	// fetch is always LAZY for a collection
	private Set<OrderDescription> orderDesc;
	
	@ManyToOne(targetEntity = Customers.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id",referencedColumnName = "id")
	private Customers customers;

	
	public Orders() {
		// TODO Auto-generated constructor stub
	}
	public Orders(int id,Date date) {
		this.id = id;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Set<OrderDescription> getOrderDesc() {
		return orderDesc;
	}
	public void setOrderDesc(Set<OrderDescription> orderDesc) {
		this.orderDesc = orderDesc;
	}
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	public void addOrderDescription(OrderDescription orderDesc) {
		if (getOrderDesc() == null) {
			setOrderDesc(new HashSet<OrderDescription>());
		}
		getOrderDesc().add(orderDesc);
		orderDesc.setOrders(this);
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", date=" + date + ", orderDesc=" + orderDesc + ", customers=" + customers + "]";
	}
}
