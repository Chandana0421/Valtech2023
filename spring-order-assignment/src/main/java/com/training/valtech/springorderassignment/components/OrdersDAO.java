package com.training.valtech.springorderassignment.components;

import java.util.List;

import org.springframework.core.annotation.Order;

public interface OrdersDAO {

	void deleteOrder(int id);

	void updateOrders(Orders order);

	void createOrders(Orders order);

	List<Orders> getAllOrders();

	Orders getOrders(int id);
	
	 List<OrderDescription> getOrderDescriptionsForOrder(Orders order);
	 
	 List<Orders> getOrdersByCustomerId(int customer_id);
	long count();

}