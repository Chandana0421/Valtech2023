package com.valtech.training.springbootassignment.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.springbootassignment.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
}
