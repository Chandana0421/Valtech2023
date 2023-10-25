package com.valtech.training.day1;

public class Point3d extends Point{
	private int z;
	public static final Point3d ORIGIN = new Point3d();
	
	public Point3d(int x, int y, int z) {
		// TODO Auto-generated constructor stub
		super(x,y);
		this.x = z;
		System.out.println("Point3d const 3 parameters");
	}
	public Point3d() {
		// TODO Auto-generated constructor stub
//		System.out.println("Point3d const 0 parameters");
	}
	@Override
	public double distance() {
//		System.out.println("Point3d dist 0 parameters");
		return Math.sqrt((x*x)+(y*y)+(z*z));
	}
	
	public double distance(int x, int y, int z) {
		System.out.println("Point3d dist 3 parameters");
		int difx = this.x-x;
		int dify = this.y-y;
		int difz = this.z-z;
		return Math.sqrt(difx*difx + dify*dify + difz*difz);
	}
	
	public double distance(Point3d p) {
		System.out.println("Point dist Point as parameters");
		this.x = p.x;
		this.y = p.y;
		this.z = p.z;
		return Math.sqrt((x*x)+(y*y)+(z*z));
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Point3d p3d = (Point3d) obj;
		return p3d.x == x && p3d.y == y;
		
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return toString().hashCode();
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return "X = " + x + "Y = " + y + "Z = " + z + " Distance = "+  distance();
	}
	
	
	
	
	
	public static void main(String[] args) {
		/*ORIGIN.x = 10;
		//Point origin
		System.out.println(Point.ORIGIN.distance());
		//Point 3d origin
		System.out.println(ORIGIN.distance());
		
		Point p = new Point3d();
		//Here Point3d's distance is called because of @override keyword
		System.out.println(p.distance());
		
		//Check out which methods are called when you use child and parent class
		//which distance method is called
		Point p1 = new Point();
		double d = p1.distance(new Point3d(10,30,20)); //check
		
		Point3d p4 = new Point3d();
		double d1 = p1.distance(new Point(10,30)); //calls point's method*/
		
		Point3d p5 = new Point3d(1,2,1);
		System.out.println(p5.equals(new Point3d(1,2,2)));
	}
}
