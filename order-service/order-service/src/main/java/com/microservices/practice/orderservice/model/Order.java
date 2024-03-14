package com.microservices.practice.orderservice.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {

	private int orderId;
	private LocalDateTime date;
	private String orderStatus;
	private int productId;
	private String productName;
	private Double price;
	private String manufacturer;
	private int port;

}