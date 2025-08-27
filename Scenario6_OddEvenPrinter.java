package com.sample;

class TaskEvenOdd implements Runnable {
	private int max;
	private Printer print;
	private boolean isEvenNumber;

	public TaskEvenOdd(Printer print2, int i, boolean b) {
		this.print = print2;
		this.max = i;
		this.isEvenNumber = b;
	}

	@Override
	public void run() {
		// Start with 2 for even thread, 1 for odd thread
		int number = isEvenNumber ? 2 : 1;

		while (number <= max) {
			if (isEvenNumber) {
				print.printEven(number);
			} else {
				print.printOdd(number);
			}
			number += 2; // move to next number of same type (odd/even)
		}
	}
}

class Printer {
	// false means odd thread's turn, true means even thread's turn
	private volatile boolean isOdd;

	/**
	 * At the start, isOdd is false, so this means it's NOT the evenThread's turn.
	 * The while condition becomes true, so wait() is called. Calling wait(): -
	 * Immediately releases the lock on the Printer object - Puts the even thread
	 * into the waiting state - The thread will stay paused until another thread
	 * (here, the oddThread) calls notify() on the same Printer object After being
	 * notified, the even thread will try to re-acquire the lock, check the
	 * condition again, and only proceed when it's finally its turn.
	 */

	synchronized void printEven(int number) {
		while (!isOdd) {
			try {

				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		System.out.println(Thread.currentThread().getName() + ":" + number);

		isOdd = false;

		notify();
	}

	/**
	 * Since isOdd is false, it means it's the oddThread's turn, so it doesn't need
	 * to wait. It prints the odd number, then flips isOdd to true (handing over the
	 * turn to the evenThread). After that, it calls notify() to wake up the
	 * evenThread if it's waiting. The evenThread will then try to grab the lock and
	 * run its part.
	 */

	synchronized void printOdd(int number) {

		while (isOdd) {
			try {
				// Wait releases the lock and pauses the odd thread here
				// It will only wake up when even thread calls notify()
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		System.err.println(Thread.currentThread().getName() + ":" + number);

		isOdd = true;

		notify();
	}
}

public class Scenario6_OddEvenPrinter {
	public static void main(String... args) {
		Printer print = new Printer();

		// Odd thread => will print 1, 3, 5...
		Thread t1 = new Thread(new TaskEvenOdd(print, 20, false), "Odd");

		// Even thread => will print 2, 4, 6...
		Thread t2 = new Thread(new TaskEvenOdd(print, 20, true), "Even");

		t1.start();
		t2.start();
	}
}
