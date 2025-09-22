package com.jpa.sample;

/**
 * ATM Operations Simulation
 *
 * This program simulates a very basic ATM machine with three main operations:
 * 1. Withdraw: Deducts money from the account if the balance is sufficient.
 * 2. Deposit: Adds money to the account.
 * 3. Check Balance: Displays the current account balance.
 *
 * The program asks the user to choose an operation and then performs it accordingly.
 * This is a simple console-based program (no database, just one account balance in memory).
 */

import java.util.Scanner;

public class Scenario2_ATMOperations {
    // Account balance (starts with some default value)
    private static double balance = 5000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display available operations
        System.out.println("Welcome to the ATM!");
        System.out.println("Choose an operation: withdraw, deposit, check_balance");
        System.out.print("Enter your choice: ");
        String operation = scanner.nextLine().toLowerCase();

        switch (operation) {
            case "withdraw":
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();

                // Check if sufficient funds are available
                if (withdrawAmount <= balance) {
                    balance -= withdrawAmount;
                    System.out.println("Withdrawal successful. New balance: " + balance);
                } else {
                    System.out.println("Insufficient funds. Current balance: " + balance);
                }
                break;

            case "deposit":
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();

                balance += depositAmount; // Add amount to balance
                System.out.println("Deposit successful. New balance: " + balance);
                break;

            case "check_balance":
                // Just display current balance
                System.out.println("Your current balance is: " + balance);
                break;

            default:
                System.out.println("Invalid operation. Please choose withdraw, deposit, or check_balance.");
        }

        scanner.close();
    }
}
