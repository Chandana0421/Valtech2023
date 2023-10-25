package com.valtech.training.jdkfeatures;

public class AscendingDescending {

	public static boolean isAscendingThenDescending(int[] array) {
		
		//checks if a huge array has a mountain pattern

		boolean isAscending = false, isDescending = false;
		
		for (int i = 1; i < array.length; i++) {
			int diff = array[i] - array[i - 1];
			if (diff >0) {
				if (isDescending == true) {
					isDescending = false;
					//return false;
				}
					isAscending = true;
			} else if (diff <0) {
				if (isDescending != true) {
					isDescending = true;
				}
			}
		}
		return (isAscending && isDescending)? true:false;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 5, 7, 2, 1 };
		System.out.println(new AscendingDescending().isAscendingThenDescending(arr));
	}
}
