package com.valtech.training.firstspringboot.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.training.firstspringboot.models.OrderModel;
import com.valtech.training.firstspringboot.services.OrderService;

@Controller
//all urls should be prefixed with /orders now. Ex: /orders/list
@RequestMapping(path = "/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/list")
	public String listOrders(Model model) {
//		model.addAttribute("orders",orderService.getAll());
//		model.addAttribute("orders",orderService.getAll().stream().map(o -> new OrderModel()).collect(Collectors.toList()));
//		return "orders/list"; //name of the page
		model.addAttribute("orders",orderService.getAll().stream().map(o -> new OrderModel(o)).collect(Collectors.toList()));
		return "orders/list";
	}
	
	@GetMapping("/new")
	public String newOrder(Model model) {
		model.addAttribute("orders", new OrderModel());
		return "orders/edit";
	}
	
	@PostMapping("/save")
	public String saveOrder(@ModelAttribute OrderModel orderModel, @RequestParam("submit") String submit,Model model) {
		if(submit.equals("Create")) {
			orderService.createOrder(orderModel.getOrder());
		}
		model.addAttribute("orders",orderService.getAll().stream().map(o -> new OrderModel(o)).collect(Collectors.toList()));
		return "orders/list";
	}
	
	
	//cancel
	@PostMapping(path = "/save", params = "cancel")
	public String cancelEditOrder(Model model) {
		model.addAttribute("orders", orderService.getAll().stream().map(o -> new OrderModel(o)).collect(Collectors.toList()));
		return "orders/list";
		
	}
	
	@GetMapping("/edit")
	public String editOrder(@RequestParam("id") long id,Model model) {
		model.addAttribute("order", new OrderModel(orderService.getOrder(id)));
		return "orders/edit";
	}
	
	//delete but you nevr delete data from db
//	@GetMapping("/delete")
//	public String deleteOrder(@RequestParam("id") long id,Model model) {
//		OrderService.del
//		model.addAttribute("orders", orderService.getAll().stream().map(o -> new OrderModel(o)).collect(Collectors.toList()));
//		return "orders/list";
//	}
}
