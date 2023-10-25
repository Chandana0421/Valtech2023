package com.valtech.training.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.valtech.training.day3.Employee;

public class CompareEmp {

	public static void main(String[] args) {
		Employee[] employees = { new Employee(1, 10, 33, "chanman", 80000,1), new Employee(4, 4, 26, "dan", 50000,2),
				new Employee(6, 30, 56, "man", 1230000,3), new Employee(10, 21, 50, "fan", 1240000,4) };

		System.out.println(" Before sorting => " + Arrays.toString(employees));
		Arrays.sort(employees, new SortBySeniority());
		System.out.println(" After sorting Employee by seniority => " + Arrays.toString(employees));
		
		Arrays.sort(employees, new SortByExperience());
		System.out.println(" After sorting Employee by experience => " + Arrays.toString(employees));

		Arrays.sort(employees, new SortByName());
		System.out.println(" After sorting Employee by name=> " + Arrays.toString(employees));

	}
}

class SortBySeniority implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getSeniority() - o2.getSeniority();
	}
}

class SortByExperience implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getExperience() - o2.getExperience();
	}

}

class SortByName implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
