package com.valtech.training.day3;

import java.util.Arrays;
import java.util.Comparator;

public class SortArray {

	public static void main(String[] args) {

        // sort Array of employee objects using Comparator interface

        Employee[] employees = {
            new Employee(10, 20, 39, "Ramesh", 50000, 101),
            new Employee(20, 23, 40, "John", 30000, 101),
            new Employee(30,  11,30, "tom", 40000, 102),
            new Employee(1, 2, 4, "Tony", 60000, 101)
        };

        System.out.println(" Before sorting => " + Arrays.toString(employees));
        Arrays.sort(employees, new SortEmployeeBySalary());
        System.out.println(" After sorting Employee by salary => " + Arrays.toString(employees));

        Arrays.sort(employees, new SortEmployeeByName());
        System.out.println(" After sorting Employee by name=> " + Arrays.toString(employees));

    }
}

class SortEmployeeBySalary implements Comparator < Employee > {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSeniority()- o2.getSeniority();
    }
}


class SortEmployeeByName implements Comparator < Employee > {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
