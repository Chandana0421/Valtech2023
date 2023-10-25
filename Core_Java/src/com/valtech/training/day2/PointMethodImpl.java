package com.valtech.training.day2;

import com.valtech.training.day1.Point;

public class PointMethodImpl implements PointMethod {

	@Override
	public Point add(Point a, Point b) {
		// TODO Auto-generated method stub
		int x = a.x + b.x;
		int y = a.y + b.y;
		Point p = new Point(x,y);
		return p;
	}

	@Override
	public Point sub(Point a, Point b) {
		int x = a.x - b.x;
		int y = a.y - b.y;
		Point p = new Point(x,y);
		return p;
	}

	@Override
	public double distance(Point a, Point b) {
		// TODO Auto-generated method stub
		int difx =b.x-a.x;
		int dify = b.y-a.y;
		return Math.sqrt(difx*difx + dify*dify);
	}

	public static void main(String[] args) {

		PointMethod p = new PointMethodImpl();
		Point a = new Point(10,10);
		Point b = new Point(20,20);
		Point p1 = p.add(a, b);
		System.out.println("X = "+p1.x+" Y = "+p1.y);
		Point p2 = p.sub(a, b);
		System.out.println("X = "+p2.x+" Y = "+p2.y);
		System.out.println(p.distance(a, b));
	;
	}

}
