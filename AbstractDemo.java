package com.example.demo;

//🔸 Real-Time Example: Payment System
//Imagine you're building a payment system for an e-commerce app.
//You need a common structure for all payment methods (e.g., CreditCard, UPI, NetBanking).

abstract class Payment {
 abstract void pay(double amount);

 void generateReceipt() {
     System.out.println("Payment successful. Receipt generated.");
 }
}

class CreditCardPayment extends Payment {
 @Override
 void pay(double amount) {
     System.out.println("Paid " + amount + " using Credit Card");
 }
}

class UpiPayment extends Payment {
 @Override
 void pay(double amount) {
     System.out.println("Paid " + amount + " using UPI");
 }
}

public class AbstractDemo {
 public static void main(String[] args) {
     Payment payment;

     payment = new CreditCardPayment();
     payment.pay(2500);
     payment.generateReceipt();

     payment = new UpiPayment();
     payment.pay(500);
     payment.generateReceipt();
 }
}
