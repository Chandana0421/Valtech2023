package com.valtech.training.springbootassignment.services;

import java.util.List;

import com.valtech.training.springbootassignment.entities.Department;

public interface DepartmentService {

	Department createDepartment(Department department);

	Department updateDepartment(Department department);

	Department getDepartment(int departmentId);

	List<Department> getAllDepartments();
	
	Department getLastDepartment();
	
	Department getFirstDepartment();
}