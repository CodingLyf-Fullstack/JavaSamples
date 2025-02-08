package com.example.demo;

import java.util.Arrays;
import java.util.Scanner;

public class SecurePasswordExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Storing password using String (Not Secure)
        System.out.print("Enter password (String): ");
        String passwordString = scanner.nextLine();
        System.out.println("Stored Password (String): " + passwordString); // Risky!

        // Storing password using char[] (More Secure)
        System.out.print("Enter password (char[]): ");
        char[] passwordCharArray = scanner.nextLine().toCharArray();
        System.out.println("Stored Password (char[]): " + Arrays.toString(passwordCharArray)); // Safe!

        // Overwrite password in memory
        Arrays.fill(passwordCharArray, '*');
        System.out.println("Password Cleared (char[]): " + Arrays.toString(passwordCharArray));

        scanner.close();
    }
}
