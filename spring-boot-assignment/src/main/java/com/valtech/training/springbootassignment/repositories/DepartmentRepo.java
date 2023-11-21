package com.valtech.training.springbootassignment.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.springbootassignment.entities.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{
	
	Department findDepartmentById(int id);
	
	@Query(value = "SELECT * FROM Department ORDER BY id DESC LIMIT 1")
	Department findTopByOrderByIdDesc();
	
	@Query(value = "SELECT * FROM Department ORDER BY id LIMIT 1")
	Department findTopByOrderById();
}
