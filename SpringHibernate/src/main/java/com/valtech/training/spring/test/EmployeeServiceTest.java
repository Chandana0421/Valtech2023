package com.valtech.training.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.hibernate.Employee;
import com.valtech.training.spring.service.EmployeeService;

class EmployeeServiceTest {

	private ApplicationContext appCtx;
	private DateFormat dateFormat;
	@BeforeEach
	void setUp() {
		appCtx = new ClassPathXmlApplicationContext("tx1.xml");
		dateFormat = new SimpleDateFormat("dd-MM-yy");
	}
	
	@AfterEach
	void tearDown() {
		((ClassPathXmlApplicationContext)appCtx).close();
	}
	@Test
	void test() throws ParseException {
		Employee e = new Employee("name",dateFormat.parse("13-02-2001"), 10000, 'F',false);
		EmployeeService empservice = (EmployeeService) appCtx.getBean("empSer");
		System.out.println(e);
		empservice.incrementSalary(e, 1000);
		System.out.println(e);
	}

}
