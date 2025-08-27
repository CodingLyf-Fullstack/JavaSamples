package com.sample;

class BankAccount {
    private int balance = 1000; // Shared resource
    private final Object lock = new Object(); // Explicit lock object

    // Method to deposit money
    public void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " is trying to deposit: " + amount);
        synchronized (lock) { // Synchronized block
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " completed deposit. New balance: " + balance);
        }
    }

    // Method to withdraw money
    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is trying to withdraw: " + amount);
        synchronized (lock) { // Synchronized block
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " completed withdrawal. New balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " failed to withdraw due to insufficient balance.");
            }
        }
    }

    // Method to check balance (not synchronized)
    public int getBalance() {
        return balance;
    }
}

public class Scenario11_BankAccount {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(); // Shared resource

        // Thread 1: Depositing money
        Thread t1 = new Thread(() -> account.deposit(500), "Thread-1");

        // Thread 2: Withdrawing money
        Thread t2 = new Thread(() -> account.withdraw(800), "Thread-2");

        // Thread 3: Withdrawing money
        Thread t3 = new Thread(() -> account.withdraw(900), "Thread-3");

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
    }
}




