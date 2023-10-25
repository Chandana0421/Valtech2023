package com.valtech.training.jdkfeatures;

public class VarArgs {
	public int add(int a,int ... b) {
		//first arg will be considered a, next all args will be considered b
		//varargs should always be the last arg
		int result = a;
		
		//b is an array
		for(int b1 : b) {
			result+=b1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		VarArgs va = new VarArgs();
		
		//you have to pass 1 arg min for a
		//a = 2, b empty array
		System.out.println(va.add(2));
		//a = 2, b = [3]
		System.out.println(va.add(2,3));
		//a = 2, b = [3,4]
		System.out.println(va.add(2,3,4));
		//a = 2, b = [3,4,5]
		System.out.println(va.add(2,3,4,5));
		
	}
}
