package com.sample;

public class Scenario10_SharedCounter_Int {
	private static int count = 0;

	public static void main(String[] args) throws InterruptedException {
		Runnable incrementTask = () -> {
			for (int i = 0; i < 1000; i++) {
				count++;
			}
		};

		Thread[] threads = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(incrementTask);
			threads[i].start();
		}

		for (Thread thread : threads) {
			thread.join(); // Wait for all threads to complete
		}

		System.out.println("Final count (without Atomic ): " + count);
	}
}