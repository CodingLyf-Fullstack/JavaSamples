package com.example.demo;

import java.util.function.*;
import java.util.Random;

public class FunctionalInterfacesExample {
    public static void main(String[] args) {
        // Predicate: Check if a password is strong (at least 8 characters)
        Predicate<String> isStrongPassword = password -> password.length() >= 8;
        System.out.println("Password 'abcd1234' valid? " + isStrongPassword.test("abcd1234")); // true
        System.out.println("Password 'pass' valid? " + isStrongPassword.test("pass")); // false

        // Function: Calculate a 10% bonus on salary
        Function<Double, Double> calculateBonus = salary -> salary * 0.10;
        System.out.println("Bonus for $50,000 salary: $" + calculateBonus.apply(50000.0)); // $5000
        System.out.println("Bonus for $80,000 salary: $" + calculateBonus.apply(80000.0)); // $8000

        // Consumer: Send notification
        Consumer<String> sendNotification = message ->
            System.out.println("Sending Notification: " + message);
        sendNotification.accept("Your order #12345 has been shipped!");
        sendNotification.accept("Your package is out for delivery!");

        // Supplier: Generate a random 6-digit OTP
        Supplier<String> otpSupplier = () -> {
            Random random = new Random();
            return String.format("%06d", random.nextInt(1000000)); // Ensures 6-digit OTP
        };
        System.out.println("\uD83D\uDD12 Your OTP is: " + otpSupplier.get());
    }
}

