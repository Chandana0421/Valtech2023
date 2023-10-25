package com.valtech.training.day2;

import com.valtech.training.day1.Point;

public interface PointMethod {
	
	
	//return type?? add(x+y) and sub(x-y), distance b/t 2points
	Point add(Point a, Point b);
	Point sub(Point a, Point b);
	double distance(Point a, Point b);
	
//	public static void main(String[] args) {
//		Point p = new Point();
//		p.disp();
//	}
}

