package com.example.demo;

class Task implements Runnable {
    int counter = 0;

    public void run() {
        for (int i = 1; i <= 5; i++) {
            counter++;
            System.out.println(Thread.currentThread().getName() + " -> Counter: " + counter+" i: "+ i);
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Task sharedTask = new Task(); // Same object shared between threads

        Thread t1 = new Thread(sharedTask, "Thread-1");
        Thread t2 = new Thread(sharedTask, "Thread-2");

        t1.start();
        t2.start();
    }
}
