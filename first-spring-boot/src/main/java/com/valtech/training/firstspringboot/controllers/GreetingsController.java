package com.valtech.training.firstspringboot.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingsController {
	
	//more comprehensive,you can specify parameters like name="scott" exceute only when name = scott
	@RequestMapping(method = RequestMethod.GET, path = "/hello")	
//	@ResponseBody
	
	//another way of writing request mapping, most commonly used
//	@GetMapping("/hello")
	
	
	//will take 0 or more args
//	public String hello(HttpServletRequest request, HttpServletResponse response, Model model) {
////		return "Hello World MVC";
//		String name = request.getParameter("name");
//		System.out.println(name);
//		model.addAttribute("name",name);
//		return "hello";
//		
//	}
	
	public String hello(@RequestParam("name") String name,Model model) {
//		return "Hello World MVC";
//		String name = request.getParameter("name");
		System.out.println("Name"+name);
		model.addAttribute("name",name);
		return "hello";
		
	}
}
