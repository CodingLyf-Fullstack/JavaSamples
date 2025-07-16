package com.example.demo.threads;

class BankAccount {
	private int balance = 1000; // Shared resource

	// Synchronized method to deposit money
	public synchronized void deposit(int amount) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " is trying to deposit: " + amount);
		Thread.sleep(5000);

		balance += amount;
		System.out.println(Thread.currentThread().getName() + " completed deposit. New balance: " + balance);
	}

	// Synchronized method to withdraw money
	public synchronized void withdraw(int amount) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " is trying to withdraw: " + amount);
		Thread.sleep(5000);
		if (balance >= amount) {
			balance -= amount;
			System.out.println(Thread.currentThread().getName() + " completed withdrawal. New balance: " + balance);
		} else {
			System.out.println(Thread.currentThread().getName() + " failed to withdraw due to insufficient balance.");
		}
	}

	// Method to check balance (not synchronized)
	public int getBalance() {
		return balance;
	}
}

public class SynchronizedMethodExample {
	public static void main(String[] args) {

		BankAccount account = new BankAccount(); // Shared resource

		// Thread 1: Depositing money
		Thread t1 = new Thread(() -> {
			try {
				account.deposit(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Thread-1");

		// Thread 2: Withdrawing money
		Thread t2 = new Thread(() -> {
			try {
				account.withdraw(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Thread-2");

		// Thread 3: Withdrawing money
		Thread t3 = new Thread(() -> {
			try {
				account.withdraw(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, "Thread-3");

		// Start all threads
		t1.start();
		t2.start();
		t3.start();

	}
}
