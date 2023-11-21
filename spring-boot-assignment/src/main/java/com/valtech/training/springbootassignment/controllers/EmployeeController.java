package com.valtech.training.springbootassignment.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.training.springbootassignment.models.EmployeeModel;
import com.valtech.training.springbootassignment.services.EmployeeService;

@Controller
@RequestMapping(path = "/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/listEmployee")
	public String listAllEmployee(Model model) {
		model.addAttribute("employee", empService.getAllEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "employee/listEmployee";
	}
	
	@GetMapping("/new")
	public String newEmployee(Model model) {
		model.addAttribute("employee", new EmployeeModel());
		return "employee/edit";
	}
	
	@PostMapping("/save")
	public String saveOrder(@ModelAttribute EmployeeModel empModel, @RequestParam("submit") String submit,Model model) {
		if(submit.equals("Create")) {
			empService.createEmployee(empModel.getEmployee());
		}
		model.addAttribute("employee",empService.getAllEmployees().stream().map(o -> new EmployeeModel(o)).collect(Collectors.toList()));
		return "employee/listEmployee";
	}
	
	
	//cancel
	@PostMapping(path = "/save", params = "cancel")
	public String cancelEditEmployee(Model model) {
		model.addAttribute("employee", empService.getAllEmployees().stream().map(o -> new EmployeeModel(o)).collect(Collectors.toList()));
		return "employee/listEmployee";
		
	}
	
	@GetMapping("/edit")
	public String editEmployee(@RequestParam("id") int id,Model model) {
		model.addAttribute("employee", new EmployeeModel(empService.getEmployee(id)));
		return "employee/edit";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id,Model model) {
		empService.deleteEmployee(id);
		model.addAttribute("employee",empService.getAllEmployees().stream().map(o -> new EmployeeModel(o)).collect(Collectors.toList()));
		return "employee/listEmployee";
	}
	
	@GetMapping("/view")
	public String viewEmployee(@RequestParam("id") int id,Model model) {
		model.addAttribute("employee", new EmployeeModel(empService.getEmployee(id)));
		return "employee/view";
	}
}
