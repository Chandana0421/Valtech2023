package com.valtech.training.day3;

import java.util.Random;

public class RandomGenerator {
//	private final Random random;
//
//    public RandomGenerator() {
//        random = new Random();
//    }
//    
//    public int generateRandomElement( int max, int  min) {
//        Random random = new Random();'
//	      return random.nextInt(max-min + 1) + min;
//    }

//    public T generateRandomElement(T[] elements) {
//        return elements[random.nextInt(elements.length)];
//    }

	
	//-----------------------------------------------
	
	
	public int generateRandomNumber( int max, int  min) {
		Random random = new Random();
		return random.nextInt(max-min + 1) + min;
	}

	public String generateRandomString() {
		String chars = "abcdefghijklmnopqrstuvwxyz";
		String firstletter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
        StringBuilder sb = new StringBuilder();
        
        int index = (int) (Math.random() * firstletter.length());
        sb.append(firstletter.charAt(index));
        
        int length = (int) (Math.random() * (10 - 3 + 1)) + 3;   //(10 - 3 + 1)) + 3;
        for (int i = 0; i < length; i++) {
            index = (int) (Math.random() * chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
	}
	
//	private static void capitalize(StringBuilder inputString) {
//
//		// get the first character of the inputString
//		char firstLetter = inputString.charAt(0);
//
//		// convert it to an UpperCase letter
//		char capitalFirstLetter = Character.toUpperCase(firstLetter);
//
//		// return the output string by updating
//		//the first char of the input string
//		
//		inputString.setCharAt(0, capitalFirstLetter);
////		return inputString.replace(0, 1, capitalFirstLetter);
//	}
}
