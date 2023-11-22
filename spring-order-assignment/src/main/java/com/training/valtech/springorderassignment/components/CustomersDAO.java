package com.training.valtech.springorderassignment.components;

import java.util.List;

public interface CustomersDAO {

	void deleteCustomer(int id);

	void updateCustomer(Customers customer);

	void createCustomer(Customers customer);

	List<Customers> getAllCustomers();

	Customers getCustomers(int id);

	Address getCustomerAddress(Customers customer);

	long count();
	
	List<Orders> getOrderForCustomers(Customers customer);
}