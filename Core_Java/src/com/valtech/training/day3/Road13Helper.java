package com.valtech.training.day3;

public class Road13Helper {
	
	public static char rotate(char achar) {
		if ((achar>='a' && achar < 'm') || (achar>= 'A' && achar < 'M') ) {
			achar = (char)(achar+13);
		}
		else if ((achar>= 'n' && achar < 'z') || (achar>= 'N' && achar < 'Z')) {
			achar = (char)(achar-13);
		}
		
		return achar;
	}
	
	public static void main(String[] args) {
		String str = "Hello World";
		
		for (int i = 0; i < str.length(); i++) {
			System.out.println(rotate(str.charAt(i)));
		}
	}
}
