package core.java.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StringPractice {

	public static void main(String[] args) {
		String repeated = "Animalll".toLowerCase();
		StringBuilder sb = new StringBuilder();
		repeated.chars().distinct().mapToObj(c -> (char) c).forEach(sb::append);
//		System.out.println(sb);

		int[] marks = { 1, 3, 44 };
		int[] marks2 = new int[] { 1, 2, 44 };

		// Reverse a String
		String str = "abcd";
		StringBuilder sb2 = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			sb2.append(str.charAt(i));
		}
		System.out.println(sb2);

		List<Integer> reversedMarks = new ArrayList<>();
		for (int i = marks.length - 1; i >= 0; i--) {
			reversedMarks.add(marks[i]);
		}
		System.out.println(reversedMarks);

		String palindrome = "abcdcba";
		int left = 0;
		int right = palindrome.length() - 1;
		boolean checkPalindrome = true;
		while (left < right && checkPalindrome) {
			if (palindrome.charAt(left) != palindrome.charAt(right)) {
				checkPalindrome = false;
			}
			left++;
			right--;
		}
		if (checkPalindrome) {
			System.out.println(palindrome + " is a palindrome");
		} else {
			System.out.println("Not a palindrome");
		}

		// count the occurances of each letter
		StringPractice sp = new StringPractice();
		Map<Character, Integer> countOfAllLetters = new HashMap<>();
		String name = "Chandana".toLowerCase();
		for (int i = 0; i < name.length(); i++) {
			countOfAllLetters.put(name.charAt(i), sp.countcharOccurances(name, name.charAt(i)));
		}
		System.out.println(countOfAllLetters.toString());

		// print a1b2c3
		String myChars = "ABCD";
		String nums = "123";
		StringBuilder sb3 = new StringBuilder();
		int length = myChars.length() > nums.length() ? myChars.length() : nums.length();
		for (int i = 0; i < length; i++) {
			sb3.append(myChars.charAt(i));
			if (i < nums.length()) {
				sb3.append(nums.charAt(i));
			}
		}
		System.err.println("Error");
		System.out.println(sb3);

		// Factorial
		int myNum = 5;
		int factorial = 1;
		for (int i = 2; i <= myNum; i++) {
			factorial *= i;
		}
		System.out.println(factorial);

		// sum of a num
		int num = 1234;
		int remainder;
		int sum = 0;
		while (num > 0) {
			remainder = num % 10;
			sum += remainder;
			num = num / 10;
		}
		System.out.println(sum);

		System.out.println(sp.findLongestWord("Vhandjsdn is kay"));

		int[] intArray = { 1, 2, 3, 4, 5 };
		List arrayList = Arrays.asList(intArray);
		System.out.println(arrayList);
	}

	public int countUppercaseLetters(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isUpperCase(str.charAt(i))) {
				count += 1;
			}
		}
		return count;
	}

	public boolean hasConsecutiveDuplicates(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (i + 1 <= str.length()) {
				if (str.charAt(i) == (str.charAt(i + 1))) {
					return true;
				}
			}
		}
		return false;
	}

	public int getRightmostDigit(String str) {
		int digit = -1;
		char myChar;
		for (int i = 0; i < str.length(); i++) {
			myChar = str.charAt(i);
			if (Character.isDigit(myChar)) {
				digit = Character.getNumericValue(myChar);
			}
		}
		return digit;
	}

	public int countcharOccurances(String str, char c) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}

	public String findLongestWord(String sentence) {
		String[] listOfWords = sentence.split(" ");
		String maxLengthWord = "";
		for (String word : listOfWords) {
			if (maxLengthWord.length() < word.length()) {
				maxLengthWord = word;
			}
		}
		return maxLengthWord;
	}

}
