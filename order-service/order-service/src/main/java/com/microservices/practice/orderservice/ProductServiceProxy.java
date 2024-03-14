package com.microservices.practice.orderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.practice.orderservice.model.Order;

@FeignClient(name = "product-service",url = "http://localhost:8001")
public interface ProductServiceProxy {
	
	@GetMapping("/view-product/{productId}")
	public Order viewProductById(@PathVariable("productId") int productId);
}
