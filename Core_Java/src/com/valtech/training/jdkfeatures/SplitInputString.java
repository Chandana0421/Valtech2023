package com.valtech.training.jdkfeatures;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SplitInputString {
	
	

	private static void sortWords(String[] stringarray) {
		
		String vowels = "aeiou";
		Map<String, Integer> counts = new HashMap<String, Integer>();
		for(String str: stringarray) {
			int count = 0;
			for(int i = 0; i < str.length(); i++) {
	            if (str.charAt(i) == 'a' || str.charAt(i) == 'e'
	                || str.charAt(i) == 'i'
	                || str.charAt(i) == 'o'
	                || str.charAt(i) == 'u') {
	                count++;
	            }
	            counts.put(str, count);
	        }
		}
		
	} 
	
	private static class Word implements Comparable<Word>{
		private String actualWord;
		private int vowelCount;
		private float ratio;
		
		public Word(String word) {
			actualWord = word;
			for(int i=0;i<word.length();i++) {
				if("aeiouAEIOU".contains(""+word.charAt(i))) {
					vowelCount++;
				}
			}
			ratio = vowelCount/word.length();
		}

		@Override
		public int compareTo(Word o) {
			// TODO Implement Logic
			return 0;
		}
		
	}
	public List<String> breakandsort(String str) {
		List<String> segments = Arrays.asList(str.split(" "));
		List<Word> words = segments.stream().map(s -> new Word(s)).collect(Collectors.toList());
		
		Collections.sort(words);
		return words.stream().map(w -> w.actualWord).collect(Collectors.toList());
		
	}
	
	
	public static void main(String args[])   
	{   
	String s = "Life is your creation";   
	String[] stringarray = s.split(" ");   
//	for(int i=0; i< stringarray.length; i++)  
//	{  
//	//prints the tokens  
//	System.out.println(stringarray[i]);  
//	}  
	sortWords(stringarray);
	}
}
