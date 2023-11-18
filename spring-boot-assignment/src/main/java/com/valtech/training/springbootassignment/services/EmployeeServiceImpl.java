package com.valtech.training.springbootassignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.springbootassignment.entities.Employee;
import com.valtech.training.springbootassignment.repositories.EmployeeRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo empRepo;
	
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
