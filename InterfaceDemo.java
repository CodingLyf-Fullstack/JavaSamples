package com.example.demo;

interface PaymentGateway {
	void makePayment(double amount);

	void cancelPayment();
}

class Razorpay implements PaymentGateway {
	public void makePayment(double amount) {
		System.out.println("Payment of " + amount + " through Razorpay");
	}

	public void cancelPayment() {
		System.out.println("Razorpay payment cancelled");
	}
}

class Paytm implements PaymentGateway {
	public void makePayment(double amount) {
		System.out.println("Payment of " + amount + " through Paytm");
	}

	public void cancelPayment() {
		System.out.println("Paytm payment cancelled");
	}
}

public class InterfaceDemo {
	public static void main(String[] args) {
		PaymentGateway gateway = new Razorpay();
		gateway.makePayment(1500);
		gateway.cancelPayment();

		gateway = new Paytm();
		gateway.makePayment(900);
		gateway.cancelPayment();
	}
}