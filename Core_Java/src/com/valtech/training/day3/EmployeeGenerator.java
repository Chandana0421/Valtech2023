package com.valtech.training.day3;

public class EmployeeGenerator {

	int age, experience, level;
	String name;

	public EmployeeGenerator() {
		
		
		RandomGenerator r = new RandomGenerator();

		age = r.generateRandomNumber(61, 20);
		experience = r.generateRandomNumber(age, 0); 
		level = r.generateRandomNumber(experience, 0);
		name = r.generateRandomString();

//		while (age < 20 || age > 61) {
//			age = r.generateRandomNumber(61,20);
//		}
//		while (experience > age || experience == 0) {
//			experience = r.generateRandomNumber();
//		}
//
//		while (level > experience) {
//			System.out.println("Level "+level);
//			level = r.generateRandomNumber(experience, 0);
//		}

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeGenerator emp = new EmployeeGenerator();
		System.out.println("Employee details \n" + "Name: " + emp.name + " Age: " + emp.age + " Experience: "
				+ emp.experience + " Level " + emp.level);
	}

}
