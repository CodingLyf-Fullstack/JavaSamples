package com.example.demo.compare;

import java.util.*;

class Product implements Comparable<Product> {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Comparable - Sorting by Price (Default)
    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price); // Ascending order
    }

    @Override
    public String toString() {
        return id + " - " + name + " : $" + price;
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product(101, "Laptop", 1200.99),
            new Product(102, "Smartphone", 899.49),
            new Product(103, "Headphones", 199.99)
        );

        // Sorting based on Comparable (Price)
        Collections.sort(products);

        System.out.println("Products sorted by Price (Default):");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
