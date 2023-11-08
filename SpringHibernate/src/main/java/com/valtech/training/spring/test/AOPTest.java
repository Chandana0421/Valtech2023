package com.valtech.training.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import com.valtech.training.spring.Arithmetic;

class AOPTest {
	
	private ClassPathXmlApplicationContext appCtx;
	
	@BeforeEach
	void initialize() {
		appCtx = new ClassPathXmlApplicationContext("aop.xml");
	}
 
	@Test
	void test() {
		Arithmetic arith = (Arithmetic) appCtx.getBean(Arithmetic.class);
		System.out.println(arith.getClass().getName()); // gives the class name
		assertEquals(7,arith.add(2, arith.add(-2, -3)));
		assertEquals(-2,arith.add(-1, arith.sub(2, 3)));
		assertEquals(10,arith.add(5, arith.sub(9, -4)));
		
		try {
			arith.div(5, 0);
			fail("No Exception occured");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@AfterEach
	void closeAllResources() {
		appCtx.close();
	}
 
}
