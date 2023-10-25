package com.valtech.training.day2;

public class DivideByZeroException extends RuntimeException{ //jsut Exception for checked exception
	
	
	//COnstructer to display excep message
	public DivideByZeroException(String message) {
		super(message);
	}
}
