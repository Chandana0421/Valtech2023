package com.valtech.training.spring;

public class ArithmeticImpl implements Arithmetic{

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		return a-b;
	}

	@Override
	public int mul(int a, int b) {
		return a*b;
	}

	@Override
	public int div(int a, int b) { //throws DivideByZeroException  //THROWS BECAUSE IT'S A CHECKED EXCEPTION, WE'VE DEFINED A CLASS
//		if(b==0) {
//			throw new DivideByZeroException("Zero cannot be used as denominator"); //Both checked and Unchecked
//		}
		return a/b;
	}

//	@Override
//	public double add(double a, double b) {
//		return a+b;
//	}
//	
	public static void main(String[] args) {
		Arithmetic ans = new ArithmeticImpl();
	}

}
