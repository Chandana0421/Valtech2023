package com.valtech.training.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.valtech.training.hibernate.Employee;

@Repository //- for all dao classes
/* @ServiceClass - for all Service classes
 * @
 * @Component - general classes
 * 
 * */
public class EmployeeDaoImpl implements EmployeeDao {

	private SessionFactory sessionFactory;

	@Override
	public Employee saveEmployee(Employee emp) {
		Session sess = sessionFactory.openSession();
		sess.persist(emp);
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Session sess = sessionFactory.openSession();
		emp = (Employee) sess.merge(emp);
		return emp;
	}

	@Override
	public Employee loadEmployee(int empId) {
		Session sess = sessionFactory.openSession();
		Employee emp = (Employee) sess.load(Employee.class, empId);
		return emp;
	}

	@Override
	public void deleteEmployee(int empId) {
		Session sess = sessionFactory.openSession();
		sess.delete(empId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		Session sess = sessionFactory.openSession();
		List<Employee> emp = sess.createQuery("from Employeee e").list();
		return emp;
}

	// for auto-wiring
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
