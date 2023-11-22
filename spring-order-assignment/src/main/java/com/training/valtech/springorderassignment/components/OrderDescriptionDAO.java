package com.training.valtech.springorderassignment.components;

import java.util.List;

public interface OrderDescriptionDAO {

	void deleteOrderDescription(int id);

	void updateOrderDescription(OrderDescription orderDesc);

	void createOrderDescription(OrderDescription orderDesc);

	List<OrderDescription> getAllOrderDescriptions();

	OrderDescription getOrderDescription(int id);
	
	List<OrderDescription> getAllOrderDescriptionByOrderId(int order_id);
	
	long count();

}