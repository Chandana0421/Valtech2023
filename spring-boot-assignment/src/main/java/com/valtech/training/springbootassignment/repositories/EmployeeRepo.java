package com.valtech.training.springbootassignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.springbootassignment.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	
}
