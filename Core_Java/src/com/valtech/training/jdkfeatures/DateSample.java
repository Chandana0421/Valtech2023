package com.valtech.training.jdkfeatures;

import java.time.LocalDate;
import java.util.Date;

public class DateSample {

	public static void main(String[] args) {

		// Index the year for 1900 i.e 1947-> 47, 2023 - 123
		// Month index with 0, august -> 7, jan -> 0
		// Index day with 1, 15 -> 15

		// Depricated
		Date date = new Date(47, 7, 15);
		System.out.println(date);

		LocalDate independenceDay = LocalDate.of(1947, 8, 15);
		System.out.println(independenceDay);
	}

}
