package com.valtech.training.firstspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.firstspringboot.components.EmployeeDAO;
import com.valtech.training.firstspringboot.components.HelloWorld;
import com.valtech.training.firstspringboot.components.SimpleInterest;
import com.valtech.training.firstspringboot.entities.Order;
import com.valtech.training.firstspringboot.services.OrderService;

@SpringBootTest
class FirstSpringBootApplicationTests {

	@Autowired
	private HelloWorld helloWorld;
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private OrderService orderService;
//	@Autowired
//	private SimpleInterest simpleInterest;
	@Test
	void contextLoads() {
		
		assertNotNull(helloWorld);
		assertEquals("Hello Spring Boot", helloWorld.hello());
	}
	
	//private test cases don't run!
	@Test
	private void testEmployee() {
		assertEquals(4, employeeDAO.count());
		assertEquals(4, employeeDAO.getAllEmployees().size());
	}
	
	@Test
	private void testOrder() {
		Order o = orderService.createOrder(new Order("Macbook Pro M3",25,"For the Entire team",LocalDate.of(2023, 11, 8)));
		assertEquals(0, o.getId());
		assertTrue(orderService.getAll().size()>0);
	}
//	
//	@Test
//	private void testSimpleInterest() {
//		simpleInterest.computeInterest(1000,4, 3);
//	}

}
