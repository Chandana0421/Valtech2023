package com.valtech.training.springbootassignment.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.training.springbootassignment.entities.Department;
import com.valtech.training.springbootassignment.models.DepartmentModel;
import com.valtech.training.springbootassignment.models.EmployeeModel;
import com.valtech.training.springbootassignment.services.DepartmentService;
import com.valtech.training.springbootassignment.services.EmployeeService;

@Controller
@RequestMapping(path = "/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService deptService;
	
	@Autowired
	EmployeeService empService;
	
	DepartmentModel deptModel;
	
	@GetMapping("/deptList2")
	public String listAllDepartments(Model model) {
		model.addAttribute("department", deptService.getAllDepartments().stream().map(e -> new DepartmentModel(e)).collect(Collectors.toList()));
		return "department/deptList2";
	}
	
	@GetMapping("/deptList")
	public String getDepartment(Model model) {
		deptModel = new DepartmentModel(deptService.getFirstDepartment());
		model.addAttribute("department", deptModel);
		model.addAttribute("employees",deptModel.getEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "department/deptList";
	}
	
	@GetMapping("/next")
	public String nextDepartment(@RequestParam("id") int id,Model model) {
		deptModel = new DepartmentModel(deptService.getDepartment(id+1));
		model.addAttribute("department",deptModel);
		model.addAttribute("employees",deptModel.getEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "department/deptList";
	}
	
	@GetMapping("/previous")
	public String previousDepartment(@RequestParam("id") int id,Model model) {
		deptModel = new DepartmentModel(deptService.getDepartment(id-1));
		model.addAttribute("department",deptModel);
		model.addAttribute("employees",deptModel.getEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "department/deptList";
	}
	@GetMapping("/first")
	public String firstDepartment(Model model) {
		deptModel = new DepartmentModel(deptService.getFirstDepartment());
		model.addAttribute("department", deptModel);
		model.addAttribute("employees",deptModel.getEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "department/deptList";
	}
	
	@GetMapping("/last")
	public String lastDepartment(Model model) {
		deptModel = new DepartmentModel(deptService.getLastDepartment());
		model.addAttribute("department", deptModel);
		model.addAttribute("employees",deptModel.getEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "department/deptList";
	}
}
