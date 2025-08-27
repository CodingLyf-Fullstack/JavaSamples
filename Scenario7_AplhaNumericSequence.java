package com.sample;

public class Scenario7_AplhaNumericSequence {

	private static final int LIMIT = 26; // Total letters and numbers to print in sequence
	private static final Object monitor = new Object(); // Shared lock object for synchronization
	private static volatile boolean isLetter = false; // Flag to decide whether to print letter or number

	public static void main(String[] args) {

		/**
		 * When the threads start, isLetter is false.
		 * The letter thread checks while(isLetter) — this is false,
		 * so it means it’s the letterThread’s turn.
		 * The letterThread prints a letter
		 * and then notifies the numberThread to run next.
		 */
		Thread letterThread = new Thread(() -> { // Thread to print letters A-Z
			for (char ch = 'A'; ch < 'A' + LIMIT; ch++) {
				synchronized (monitor) {
					while (isLetter) { 
						try {
							monitor.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.err.print(ch + " "); // Print current letter
					isLetter = true; // Set flag so number thread can run
					monitor.notify(); // Wake number thread
				}
			}
		});

		/**
		 * When the threads start and isLetter is true, the numberThread waits for its turn.
		 * Once the letterThread prints a letter and calls notify(),
		 * the numberThread wakes up, prints the number,
		 * changes isLetter to false so the letterThread can run,
		 * and releases the lock for the letterThread.
		 */
		Thread numberThread = new Thread(() -> { // Thread to print numbers 1-26
			for (int i = 1; i <= 26; i++) {
				synchronized (monitor) { 
					while (!isLetter) { 
						try {
							monitor.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.print(i + " "); // Print current number
					isLetter = false; // Set flag so letter thread can run
					monitor.notify(); // Wake letter thread
				}
			}
		});
		numberThread.start(); // Start number thread
		letterThread.start(); // Start letter thread
	}
}
