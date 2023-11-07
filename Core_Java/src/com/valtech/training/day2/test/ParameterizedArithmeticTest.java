package com.valtech.training.day2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.valtech.training.day2.Arithmetic;
import com.valtech.training.day2.ArithmeticImpl;

class ParameterizedArithmeticTest {

	private Arithmetic arithmetic = new ArithmeticImpl();
	@Test
	void testAdd() {
	}

	@Test
	void testSub() {
	}
	
	
	//{0 is an arg here}
	@ParameterizedTest(name= "Add with {0}")
	@ValueSource(strings = {"2,3,5","-2,3,1","5,-2,3","-1,-1,-2"})
	void testAddWithParameters(String value) {
		String[] parts = value.split(",");
		List<Integer> values = Arrays.asList(parts).stream().map(it -> Integer.parseInt(it)).collect(Collectors.toList());
		assertEquals(values.get(2),arithmetic.add(values.get(0),values.get(1)));
	}
	
	@ParameterizedTest(name= "Add with CSV {0} + {1} = {2}")
	@CsvSource(value = {"2,3,5","-2,3,1","5,-2,3","-1,-1,-2"})
	void testWithCSVParams(int a, int b, int c){
		assertEquals(c, arithmetic.add(a, b));
	}
	
	@ParameterizedTest(name= "Add with CSV {0} + {1} = {2}")
	@CsvFileSource(files = {"add.csv"})
	void testWithCSVFile(int a, int b, int c){
		assertEquals(c, arithmetic.add(a, b));
	}
	
	@ParameterizedTest(name= "Add with method {0} + {1} = {2}")
	@MethodSource(value = "addArgsGenerator") //this method has to be static!
	void testWithMethod(int a, int b, int c){
		assertEquals(c, arithmetic.add(a, b));
	}
	
	static Stream<Arguments> addArgsGenerator() {
		return Stream.of(
				Arguments.of(1,2,3),
				Arguments.of(-1,-2,-3),
				Arguments.of(1,-2,-1),
				Arguments.of(-1,2,1)
				);
	}
	
	@Test
	void testMul() {
	}

	@Test
	void testDiv() {
	}

}
