package com.sample;

public class Scenario25_SimpleRetry {

    public static void main(String[] args) {
        int maxRetries = 3;
        long retryDelayMillis = 1000; // 1 second

        for (int i = 0; i < maxRetries; i++) {
            try {
                // Your operation that might fail
                performOperation();
                System.out.println("Operation successful!");
                break; // Exit loop on success
            } catch (Exception e) {
                System.err.println("Operation failed. Retrying... (Attempt " + (i + 1) + ")");
                
                if ((i + 1) == maxRetries) {
					System.err.println("Retries exhausted");
				}
                try {
                    Thread.sleep(retryDelayMillis); // Wait before retrying
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt(); // Restore interrupt status
                    System.err.println("Retry delay interrupted.");
                }
            }
        }
    }

    private static void performOperation() throws Exception {
        // Simulate an operation that fails randomly
        if (Math.random() < 0.7) { // 70% chance of failure
            throw new Exception("Simulated operation failure.");
        }
        System.out.println("Operation executed successfully.");
    }
}