package com.sample;

public class Scenario9_Deadlock {

    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();

    public static void main(String[] args) {
        // Thread 1: Locks resource1 then resource2
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Locked resource1");
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Thread 1: Waiting for resource2");
                synchronized (resource2) {
                    System.out.println("Thread 1: Locked resource2");
                }
            }
        });

        // Thread 2: Locks resource2 then resource1
        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Locked resource2");
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Thread 2: Waiting for resource1");
                synchronized (resource1) {
                    System.out.println("Thread 2: Locked resource1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}