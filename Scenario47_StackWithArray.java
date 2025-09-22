package com.sample;

class ArrayStack {
	private int maxSize;
	private int[] stackArray;
	private int top;
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		this.stackArray = new int[this.maxSize];
		this.top = -1;
	}
	
	public void push(int element) {
		this.stackArray[++top] = element;
	}
 	
	public int pop() {
		if(isEmpty()) return -1;
		return this.stackArray[top--];
	}
	
	public int peek() {
		if(isEmpty()) return -1;
		return this.stackArray[top];
	}
	
	boolean isEmpty() {
		return top == -1;
	}
	
	boolean isFull() {
		return top == maxSize-1;
	}
}

public class Scenario26_StackWithArray {
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(16);
		stack.push(10);
		stack.push(11);
		stack.push(12);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}

