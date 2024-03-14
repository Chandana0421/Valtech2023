package com.microservices.practice.orderservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Product {

	private int productId;
	private String productName;
	private Double price;
	private String manufacturer;
	private int port;

	public Product(int id, String productName, Double price, String manufacturer) {
		this.productId = id;
		this.productName = productName;
		this.price = price;
		this.manufacturer = manufacturer;
	}
}
