package com.sample;

import java.util.concurrent.atomic.AtomicInteger;

public class Scenario10_SharedCounter_Atomic {
    private static AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                atomicCount.incrementAndGet();
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

        System.out.println("Final count (with AtomicInteger): " + atomicCount.get());
    }
}