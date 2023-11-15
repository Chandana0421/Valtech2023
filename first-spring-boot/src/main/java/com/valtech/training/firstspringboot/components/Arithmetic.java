package com.valtech.training.firstspringboot.components;

public interface Arithmetic {
	//variables inside an INTF are always public static final var
	int ZERO = 0;
	
	//methods are public by default (no private, protected and default access specifier)
	//methods end with ;
	int add(int a, int b);
	int sub(int a, int b);
	int mul(int a, int b);
	int div(int a, int b);
	
	//Overload methods in intf
	//static double add(double a, double b); - static no semicolon, intf semicolom
//	double add(double a, double b);
	
	//you can have main
	public static void main( String[] args ) {
		System.out.println("HEllo");
	}
}