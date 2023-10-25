package com.valtech.training.day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.valtech.training.day1.Point;
import com.valtech.training.day1.Point3d;

public class SerialTest {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		//Serialization of Point class 
		
//		Point p = new Point();
//		System.out.println(p);
//		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("object")));
//		out.writeObject(p);
//		out.flush();
//		out.close();
//		
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("object")));
//		Point p1 = (Point) ois.readObject();
//		
//		System.out.println(p1);
//		System.out.println(p==p1);
		
		//Serialization of Point3d class after setting y as transient
		
		Point3d point3d = new Point3d();
		System.out.println(point3d);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("object")));
		out.writeObject(point3d);
		out.flush();
		out.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("object")));
		Point3d point = (Point3d) ois.readObject();
		
		System.out.println(point);
		System.out.println(point==point3d);
	}
}
