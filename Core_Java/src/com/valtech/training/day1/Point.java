package com.valtech.training.day1;

import java.io.Serializable;

public class Point implements Comparable<Point>, Serializable{
	
	//1. CONSTANTS
	//2.CONSTRUCTER
	//3. VARIABLES
	//4. STATIC BLOCK
	//5. METHOD
	
	//to define origin, set x or y to different value. By default x and y is 0
	public static final Point ORIGIN = new Point();
	public int x;
	public transient int y = 3;
	
	public Point() {
//		System.out.println("Point const 0 parameters");
		// TODO Auto-generated constructor stub
	}	
	public Point(int x, int y) {
		// TODO Auto-generated constructor stub
		//System.out.println("Point const 2 parameters");
		this.x = x;
		this.y = y;
	}

	public double distance(){
		//System.out.println("Point dist 0 parameters");
		return Math.sqrt((x*x)+(y*y));
	}
	
	//method overloading and this keyword
	public double distance(int x, int y) {
		//System.out.println("Point dist 2 parameters");
		int difx = this.x-x;
		int dify = this.y-y;
		return Math.sqrt(difx*difx + dify*dify);
	}
	
	public double distance(Point p) {
		//System.out.println("Point dist Point as parameters");
		this.x = p.x;
		this.y = p.y;
		return Math.sqrt((x*x)+(y*y));
	}
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Point p = (Point) obj;
		return p.x == x && p.y == y;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return toString().hashCode();
	}
	
	@Override
	public String toString() {
		return "X = " + x + " Y = " + y + " Distance = "+  distance();
	}
	
	
	@Override
	public int compareTo(Point o) {
		return (x-o.x) == 0 ? (y-o.y): (x-o.x);
	}
	
	public void disp() {
		System.out.println("disp");
	}
	
	
	
	public static void main(String[] args) {
		/*Point p = new Point();
		p.x = 2;
		p.y = 3;
		System.out.println(p.distance());
		*/
		Point p = new Point(10,10);
		System.out.println(p.toString());
		
	}
}
