package com.valtech.training.day3;

public class ThreadsTest {

	public static class PrinterThread extends Thread {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread() + " ");
			}

		}
	}

	public static class PrinterThreadByIntf implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread() + " ");
			}

		}
	}

	public static void main(String[] args) {
		new PrinterThread().start();
		new PrinterThread().start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread() + " ");
		}
		
		//Thread constructor takes a Runnable implemented class
		//new Thread(new PrinterThreadByIntf()).start();
		
		//ANONYMOUS CLASS!
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread() + " ");
				}
			}
		}).start();
	}

	// Thread[Thread-0,5,main] -> [name of thread, priority, parent thread]
}