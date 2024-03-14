package com.microservices.practice.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.practice.orderservice.ProductServiceProxy;
import com.microservices.practice.orderservice.model.Order;

@RestController
public class OrderController {

	@Autowired
	ProductServiceProxy productServiceProxy;

	@GetMapping("/view-order/id/{productId}")
	public Order viewOrder(@PathVariable("productId") int productId) {
		
		return productServiceProxy.viewProductById(productId);
	}
}
