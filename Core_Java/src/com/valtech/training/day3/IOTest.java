package com.valtech.training.day3;

import java.io.*;

public class IOTest {

	public static void main(String[] args) throws IOException {
//		writeToFile();
//		readFromFile();
//		rotateAndWrite();
		readAndRotate();	}
	

	public static void readAndRotate() throws IOException {
		// TODO Auto-generated method stub
		Reader in = new Road13Reader(new FileReader(new File("Road13 stuff.txt")));
		char[] buffer = new char[1024];
		int bytesread = in.read(buffer);
		in.close();
		System.out.println(new String(buffer,0,bytesread));

	}


	public static void rotateAndWrite() throws IOException {
		Writer out = new Road13Writer(new FileWriter(new File("Road13 stuff.txt")));
		out.write("Helloow wpriiS");
		out.flush();
		out.close();
	}
			

	private static void readFromFile() throws IOException {
		FileInputStream fis = new FileInputStream("Hello.txt");
		byte[] buffer = new byte[1024];
		int bytesRead = fis.read(buffer);
		System.out.println("bytes read = "+bytesRead);
		System.out.println(new String(buffer, 0, bytesRead));
	}


	private static void writeToFile() throws IOException {
		String message = "heyyyy";
		FileOutputStream file = new FileOutputStream(new File("Hello.txt"));
		file.write(message.getBytes());
		file.flush();
		file.close();
	}

}
