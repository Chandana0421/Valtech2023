package com.valtech.training.day2.test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.valtech.training.day2.Arithmetic;
import com.valtech.training.day2.ArithmeticImpl;
import com.valtech.training.day2.DivideByZeroException;

class ArithmeticTest {

	private Arithmetic arithmetic;
	
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("Init ONLY ONCE");
	}
	
	
	@AfterAll
	static void afterAll() {
		System.out.println("Destroy ONLY ONCE");
	}
	
	@BeforeEach
	void initBefore() {
		arithmetic = new ArithmeticImpl();
		System.out.println("Init called before every method/text case");
	}
	
	@AfterEach
	void cleanupAfter() {
		System.
		out.println("Called after every method/text case");
	}
	
	@Test @DisplayName("To check if +ve and -ve numbers are added correctly")
	void testAdd() {
		assertEquals(5, arithmetic.add(2, 3));
		assertEquals(5, arithmetic.add(3, 2));
		assertEquals(5, arithmetic.add(5, 0));
		assertEquals(5, arithmetic.add(5, -0));
		assertEquals(-5, arithmetic.add(-2, -3));
		assertEquals(-5, arithmetic.add(-8, 3));
	}

	@Test
	void testSub() {
		
	}

	@Test
	void testMul() {
		
	}

	@Test
	void TestDivByZero() {
		//second arg is an execution so we give an expression
		assertThrows(DivideByZeroException.class,() -> arithmetic.div(5, 0));
	}
	
	
	@Test
	void testDiv() {
		
		assertEquals(2, arithmetic.div(4, 2));
		assertEquals(2, arithmetic.div(-6, -3));
		try {
		assertEquals(2, arithmetic.div(4, 0));
		fail("Should have thrown an Arithmetic exception");
		}catch (DivideByZeroException e) {
			// TODO: handle exception
		}
	}

}
