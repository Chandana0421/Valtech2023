package com.valtech.training.day2;


public class Outer {
	private int x;
	
	
	public Inner createInner() {
		return new Inner();
	}
	
	//private class Inner is possible, but instance of inner can only be within Inner
	public class Inner{
		
		public void printX() {
			System.out.println("X = "+ x);
		
		}
		
		public void increment() {
			x++;
		}
		
	}
	
	//INTERFACE
	public static interface abcd{
		
	}
	
	//STATIC CLASS only permitted for INNER CLASS
	//new StaticInner -> not possible because abstract
	public abstract static class StaticInner implements abcd{
		public void jumpBy10(Outer o) {
			o.x = o.x + 10;
		}
		
		public abstract void jumpBy100(Outer o);
	}
	
	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.Inner i = o.createInner(); // or o.new Inner();
		Outer.Inner i1 = o.createInner(); 
		i1.increment();
		i.printX();
		
		//different outer instance
		new Outer().createInner().printX();
		
		//ANONYMOUS CLASS
		
		//INSTANTIATING ABSTRACT STATIC INNER CLASS
		StaticInner s1 = new StaticInner() {
			
			//ABSTRACT METHOD INSIDE STATICINNER
			@Override
			public void jumpBy100(Outer o) {
				o.x = o.x + 100;
			}
			
		};
		s1.jumpBy10(o);
		s1.jumpBy100(o);
		i.printX();
		
		Arithmetic ar = new Arithmetic() {
			
			@Override
			public int sub(int a, int b) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int mul(int a, int b) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int div(int a, int b) throws DivideByZeroException {
				// TODO Auto-generated method stub
				return 0;
			}
			
			//@Override
//			public double add(double a, double b) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
			
			@Override
			public int add(int a, int b) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
	}
}
