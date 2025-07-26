package com.example.demo;;

import java.util.*;

class Product {
	int id;
	String name;
	double price;

	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return id + " - " + name + " : $" + price;
	}
}

//Comparator to Sort by Name (Alphabetically)
class NameComparator implements Comparator<Product> {
	@Override
	public int compare(Product p1, Product p2) {
		return p1.name.compareTo(p2.name);
	}
}

//Comparator to Sort by Price (Descending)
class PriceComparatorDescending implements Comparator<Product> {
	@Override
	public int compare(Product p1, Product p2) {
		return Double.compare(p2.price, p1.price); // Descending order
	}
}

public class ComparatorExample {
	public static void main(String[] args) {
		List<Product> products = Arrays.asList(new Product(101, "Laptop", 1200.99),
				new Product(102, "Smartphone", 899.49), new Product(103, "Headphones", 199.99));

		// Sorting by Name
		Collections.sort(products, new NameComparator());
		System.out.println("Products sorted by Name:");
		for (Product p : products) {
			System.out.println(p);
		}

		// Sorting by Price (Descending)
		Collections.sort(products, new PriceComparatorDescending());
		System.out.println("\nProducts sorted by Price (Descending):");
		for (Product p : products) {
			System.out.println(p);
		}

	}
}
