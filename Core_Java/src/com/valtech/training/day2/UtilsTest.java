package com.valtech.training.day2;

import java.util.*;

import com.valtech.training.day1.Point;

public class UtilsTest {
	
	//SET
	public static void testSet(Set<Point> points) {
		Point p = new Point(2,3);
		Point p1 = new Point(2,3);
		
		//p and p1 are treated as different objects even if the content is same
		//Set<Point> points = new HashSet<>();
		points.add(p);
		points.add(p1);
		points.add(p);
		points.add(new Point(3,2));
		points.add(new Point(2,4));
		points.add(new Point(4,2));
		//COMMENT EQUALS() AND HASHCODE() IN POINT CLASS AND CHECK O/P
		//UNCOMMENTED - USES HASCODE() AND EQUALS() TO CHECK IF OBJ EXISTS IN SET
		System.out.println("Size =" + points.size()); 
	}
	
	//LIST
	public static void testList(List<Point> points) {
		Point p = new Point(2,3);
		Point p1 = new Point(2,3);
		
		points.add(p);
		points.add(p1);
		points.add(p);
		points.add(new Point(3,2));
		points.add(new Point(2,4));
		points.add(new Point(4,2));
		//COMMENT EQUALS() AND HASHCODE() IN POINT CLASS AND CHECK O/P
		//UNCOMMENTED - USES HASCODE() AND EQUALS() TO CHECK IF OBJ EXISTS IN SET
		System.out.println("Size = " + points.size());
	}
	
	//Map
	//only relies on the uniqueness of the key, value duplicates are allowed
	public static void testMap(Map<String,Point> points) {
		points.put("2,3", new Point(2,3));
		points.put("2,3", new Point(2,3));
		points.put("3,2", new Point(3,2));
		points.put("2,4", new Point(2,4));
		System.out.println(points.size());
		System.out.println(points);
	}
	//stack
	public static void testStack(Stack<Point> points) {
		points.push( new Point(2,3));
		points.push( new Point(2,3));
		points.push( new Point(3,2));
		points.push( new Point(2,4));
		System.out.println("Size " + points.size());
		System.out.println(points.pop());
		System.out.println("Size " + points.size());
		System.out.println(points.peek()); //Display last element
	}
	
	//queue
	public static void testStack(Queue<Point> points) {
		points.add( new Point(2,3));
		points.add( new Point(2,3));
		points.add( new Point(3,2));
		points.add( new Point(2,4));
		System.out.println("Size " + points.size());
		System.out.println(points.peek()); //Display last element
	}

	public static void main(String[] args) {
		
//		testSet(new HashSet<>());
//		testSet(new TreeSet<Point>()); //YOU'LL GET ERROR W/O COMPARABLE INTF IN POINT CLASS
		
		
		//you can use ARRAYLIST OR LINKEDLIST because both of them implement LIST interface
//		testList(new ArrayList<Point>());
//		testList(new LinkedList<Point>());
		
		//ARRAYLIST is more efficient because you are adding sequentially
		
//		testMap(new HashMap<>());
//		testMap(new TreeMap<String, Point>());
		//Order of both will be different
		
		testStack(new Stack<Point>());
	}

}
