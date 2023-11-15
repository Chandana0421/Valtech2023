package com.valtech.training.firstspringboot.services;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.firstspringboot.entities.Order;
import com.valtech.training.firstspringboot.repositories.OrderRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService  {

	@Autowired
	private OrderRepo orderRepo;
	
	//Init method like before/const, @predestruct for destroy
	@PostConstruct
	public void populateTable() {
		orderRepo.save(new Order("Macbook Pro M3",25,"For the Entire team",LocalDate.of(2023, 11, 8)));
		orderRepo.save(new Order("IPhone 15 Pro Max",25,"For the Entire team",LocalDate.of(2023, 11, 8)));
		orderRepo.save(new Order("Airpods",25,"For the Entire team",LocalDate.of(2023, 11, 8)));
	}
	@Override
	public Order createOrder(Order order){
		System.out.println(orderRepo.getClass().getName());
		return orderRepo.save(order);
	}
	
	@Override
	public Order updateOrder(Order order){
		return orderRepo.save(order);
	}
	
	@Override
	public Order getOrder(long orderId){
		return orderRepo.getReferenceById(orderId);
	}
	
	@Override
	public List<Order> getAll(){
		return orderRepo.findAll();
	}
}
