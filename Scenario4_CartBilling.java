package com.jpa.sample;

/**
 * Cart Billing System
 *
 * This program simulates calculating a shopping cart bill.
 * Rules:
 * 1. Loop through each cart item and add (price × quantity) to total.
 * 2. If total > 10,000, stop processing further items (simulate max cart limit).
 * 3. If total > 5,000 (after processing items), apply a 10% discount.
 */

import java.util.*;

class CartItem {
    String name;
    double price;
    int quantity;

    CartItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

public class Scenario4_CartBilling {
    public static void main(String[] args) {
        // Sample cart items
        List<CartItem> cart = Arrays.asList(
                new CartItem("Laptop", 40000, 1),
                new CartItem("Mouse", 500, 2),
                new CartItem("Keyboard", 1500, 1),
                new CartItem("Monitor", 12000, 1)
        );

        double total = 0.0;

        // Loop through cart
        for (CartItem item : cart) {
            double itemCost = item.price * item.quantity;
            total += itemCost;

            // Stop if cart limit crossed
            if (total > 10000) {
                System.out.println("Max cart limit reached! Stopping calculation.");
                break;
            }
        }

        // Apply discount if eligible
        if (total > 5000) {
            total = total - (total * 0.10);
            System.out.println("10% discount applied.");
        }

        System.out.println("Final Total Bill: " + total);
    }
}

