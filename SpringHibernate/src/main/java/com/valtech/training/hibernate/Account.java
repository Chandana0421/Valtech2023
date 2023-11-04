package com.valtech.training.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double balance;
	private String accountType;
	@OneToMany(targetEntity = Tx.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "account")
	// fetch is always LAZY for a collection
	private Set<Tx> tx;
	
	//no cascade because account and customer are two independent guys
	@ManyToMany(targetEntity = Customer.class, fetch = FetchType.LAZY)
	//join columns -> this table to join table, inverseJoin -> this table to join table
	@JoinTable(name = "customer_account",joinColumns = @JoinColumn(name = "account_id",referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name="customer_id",referencedColumnName = "id"))
	private Set<Customer> customers;

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public Account(double balance, String accountType) {
		this.balance = balance;
		this.accountType = accountType;
	}

	public Account() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setTx(Set<Tx> tx) {
		this.tx = tx;
	}

	public Set<Tx> getTx() {
		return tx;
	}

	public void addTx(Tx tx) {
		if (getTx() == null) {
			setTx(new HashSet<Tx>());
		}
		getTx().add(tx);
		tx.setAccount(this);
	}
	
	public void addCustomer(Customer c) {
		if(getCustomers()==null) {
			setCustomers(new HashSet<Customer>());
		}
		getCustomers().add(c);
		
		if(c.getAccounts()==null) {
			c.setAccounts(new HashSet<Account>());
		}
		c.getAccounts().add(this);
	}
}
