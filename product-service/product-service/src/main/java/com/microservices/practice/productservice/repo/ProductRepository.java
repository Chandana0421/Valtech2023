package com.microservices.practice.productservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.practice.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
}
