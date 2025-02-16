package com.example.demo;

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}


public class LambdaExample {
	public static void main(String args[]) {
		System.out.println("Traditional Anonymous Class Implementation");
		MathOperation addition = new MathOperation() {
			
			@Override
			public int operate(int a, int b) {
				return a+b;
			}
		};
		
		MathOperation multiplication = new MathOperation() {
			
			@Override
			public int operate(int a, int b) {
				return a*b;
			}
		};
		System.out.println("Sum:-  "+addition.operate(3,2));
		System.out.println("Product:-  "+multiplication.operate(3,2));
		
		System.out.println("Using Lambda Expression");
		
		MathOperation addMathOperation = (a,b) -> a+b;
		MathOperation multiplyMathOperation = (a,b) -> a*b;
		
		System.out.println("Sum:-  "+addMathOperation.operate(3,2));
		System.out.println("Product:-  "+multiplyMathOperation.operate(3,2));
	}
}
