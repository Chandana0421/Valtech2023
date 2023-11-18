package com.valtech.training.springbootassignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.springbootassignment.entities.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer>  {

}
