package com.jpa.sample;

/**
 * Password Strength Checker
 *
 * This program checks if a given password is strong or weak.
 * Rules:
 * 1. Loop through each character of the password.
 * 2. Count uppercase letters, lowercase letters, digits, and special characters.
 * 3. A "Strong password" must:
 *      - Contain at least one uppercase
 *      - Contain at least one lowercase
 *      - Contain at least one digit
 *      - Contain at least one special character
 *      - Have length >= 8
 * 4. Otherwise, it's considered a "Weak password".
 */

public class Scenario5_PasswordChecker {
    public static void main(String[] args) {
        String password = "Abc@1234";  // test input

        int upperCount = 0, lowerCount = 0, digitCount = 0, specialCount = 0;

        // Loop through each character
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upperCount++;
            } else if (Character.isLowerCase(ch)) {
                lowerCount++;
            } else if (Character.isDigit(ch)) {
                digitCount++;
            } else {
                specialCount++;
            }
        }

        // Strength check
        if (password.length() >= 8 &&
            upperCount > 0 &&
            lowerCount > 0 &&
            digitCount > 0 &&
            specialCount > 0) {

            System.out.println("Strong password");
        } else {
            System.out.println("Weak password");
        }
    }
}

