package com.microservices.practice.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.practice.productservice.model.Product;
import com.microservices.practice.productservice.repo.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private ProductRepository repository;

	@GetMapping("/view-product/{productId}")
	public Product viewProductById(@PathVariable("productId") int productId){
		 Product product = repository.getReferenceById(productId);
		 product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		 return product;
	}
}
