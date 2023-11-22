package com.training.valtech.springorderassignment.components;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Orders {

	private int id;
	private Date date;
	private int customer_id;

	
	public Orders() {
		// TODO Auto-generated constructor stub
	}
	public Orders(int id,Date date) {
		this.id = id;
		this.date = date;
	}
	public Orders(Date date, int customer_id) {
		super();
		this.date = date;
		this.customer_id = customer_id;
	}
	public Orders(int id, Date date, int customer_id) {
		this.id = id;
		this.date = date;
		this.customer_id = customer_id;
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

	@Override
	public int hashCode() {
		return Objects.hash(customer_id, date, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return customer_id == other.customer_id && Objects.equals(date, other.date) && id == other.id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", date=" + date + ", customers=" + customer_id + "]";
	}

}
