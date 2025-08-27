package com.sample;

//Payment method contract
 interface PaymentMethod {
 void pay(double amount);
 String getName();
}

//Existing implementations
 class UpiPayment implements PaymentMethod {
 @Override
 public void pay(double amount) {
     System.out.println("Paying " + amount + " via UPI");
 }

 @Override
 public String getName() {
     return "UPI";
 }
}

 class CardPayment implements PaymentMethod {
 @Override
 public void pay(double amount) {
     System.out.println("Paying " + amount + " via Card");
 }

 @Override
 public String getName() {
     return "Card";
 }
}

//Payment processor
 class PaymentProcessor {
 public void processPayment(PaymentMethod method, double amount) {
     method.pay(amount);
 }
}

//Usage
public class Scenario13_PaymentIntegration {
 public static void main(String[] args) {
     PaymentProcessor processor = new PaymentProcessor();

     processor.processPayment(new UpiPayment(), 500.0);
     processor.processPayment(new CardPayment(), 1200.0);

     // Third party can easily add WalletPayment without touching our code
 }
}

