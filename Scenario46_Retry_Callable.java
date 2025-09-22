package com.sample;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Scenario25_Retry_Callable {

    public static <T> T executeWithRetry(Callable<T> callable, int maxRetries, long delayMillis) throws Exception {
        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                return callable.call(); // Attempt to execute the callable
            } catch (Exception e) {
                if (attempt == maxRetries) {
                    throw e; // Re-throw the exception on the last attempt
                }
                System.out.println("Attempt " + attempt + " failed. Retrying in " + delayMillis + "ms. Error: " + e.getMessage());
                TimeUnit.MILLISECONDS.sleep(delayMillis); // Wait before retrying
            }
        }
        // This line should technically be unreachable if maxRetries > 0
        throw new IllegalStateException("Unexpected state: Retry loop completed without success or throwing exception.");
    }

    public static void main(String[] args) {
        // Example usage:
        Callable<String> myCallable = () -> {
            // Simulate an operation that might fail
            if (Math.random() < 0.7) { // 70% chance of failure
                throw new RuntimeException("Simulated network error or temporary issue.");
            }
            return "Operation successful!";
        };

        try {
            String result = executeWithRetry(myCallable, 3, 1000); // Max 3 retries, 1-second delay
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Operation failed after multiple retries: " + e.getMessage());
        }
    }
}