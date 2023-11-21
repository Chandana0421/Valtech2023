package com.valtech.training.springbootassignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.springbootassignment.entities.Department;
import com.valtech.training.springbootassignment.repositories.DepartmentRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	DepartmentRepo deptRepo;
	
	
	@Override
	public Department createDepartment(Department department) {
		System.out.println("Creating employee");
		return deptRepo.save(department);
	}
	@Override
	public Department updateDepartment(Department department) {
		System.out.println("Updating employee");
		return deptRepo.save(department);
	}
	
	@Override
	public Department getDepartment(int departmentId) {
		return deptRepo.getReferenceById(departmentId);
	}
	
	@Override
	public List<Department> getAllDepartments(){
		return deptRepo.findAll();
	}
	@Override
	public Department getLastDepartment() {
		return deptRepo.findTopByOrderByIdDesc();
	}
	@Override
	public Department getFirstDepartment() {
		return deptRepo.findTopByOrderById();
	}
	
}
