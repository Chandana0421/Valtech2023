package com.valtech.training.springbootassignment.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.springbootassignment.entities.Department;
import com.valtech.training.springbootassignment.entities.Employee;
import com.valtech.training.springbootassignment.repositories.DepartmentRepo;
import com.valtech.training.springbootassignment.repositories.EmployeeRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo empRepo;
	@Autowired
	DepartmentRepo deptRepo;
	@PostConstruct
	public void populateTable() {
		//int id, int seniority, int experience, int age, String name, int salary, Department department
//		empRepo.save(new Employee(1,2,4,24,"Aisha","Anon",60000,deptRepo.getReferenceById(1)));
	}
	
	@Override
	public Employee createEmployee(Employee employee) {
		System.out.println("Creating employee");
		return empRepo.save(employee);
	}
	@Override
	public Employee updateEmployee(Employee employee) {
		System.out.println("Updating employee");
		return empRepo.save(employee);
	}
	
	@Override
	public Employee getEmployee(int employeeId) {
		return empRepo.getReferenceById(employeeId);
	}
	
	@Override
	public List<Employee> getAllEmployees(){
		return empRepo.findAll();
	}
	@Override
	public void deleteEmployee(int id) {
		empRepo.deleteById(id);
	}
	
}
