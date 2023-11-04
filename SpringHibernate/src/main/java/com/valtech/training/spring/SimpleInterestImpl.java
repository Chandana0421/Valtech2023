package com.valtech.training.spring;

public class SimpleInterestImpl implements SimpleInterest{
	
	private Arithmetic arithmetic;
	
	public SimpleInterestImpl(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}

	public void setArithmetic(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}

	@Override
	public double computeInterest(int principle, int rateOfInterest, int duration) {
		int result = arithmetic.mul(principle, rateOfInterest);
		result = arithmetic.mul(duration, result);

		return arithmetic.div(result, 100);
	}

	
	public SimpleInterestImpl() {
	}

	public static void main(String[] args) {
		Arithmetic arithmetic1 = new ArithmeticImpl();
		SimpleInterest si = new SimpleInterestImpl(arithmetic1);
		System.out.println(si.computeInterest(20,3,4));
	}
}
