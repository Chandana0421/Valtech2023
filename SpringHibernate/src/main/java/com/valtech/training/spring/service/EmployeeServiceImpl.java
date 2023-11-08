package com.valtech.training.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.hibernate.Employee;
import com.valtech.training.spring.dao.EmployeeDao;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao empdao;

	@Override
	public Employee createEmployee(Employee e) {
		e.setActive(true);
		return empdao.saveEmployee(e);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Employee makeActive(Employee e) {
		e.setActive(true);
		return empdao.updateEmployee(e);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Employee makeInActive(Employee e) {
		e.setActive(false);
		return empdao.updateEmployee(e);
	}
	
	@Override
	public Employee incrementSalary(Employee e, float increment) {
		e.setSalary(e.getSalary()+increment);
		
		//you can use hibernate refresh method to make sure you are using the same session or somethn
		return empdao.updateEmployee(e);
	}
	
	@Override
	public void incrementSalaryForAll(int increment) {
		empdao.getAllEmployees().forEach(e -> e.setSalary(e.getSalary()+increment));
	}

	public void setEmpdao(EmployeeDao empdao) {
		this.empdao = empdao;
	}
}
