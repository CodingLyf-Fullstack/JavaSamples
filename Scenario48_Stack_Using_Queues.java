package com.sample;

import java.util.LinkedList;
import java.util.Queue;

class QueueStack {
	private Queue<String> q1; // Main queue, always holds the stack elements in LIFO order
	private Queue<String> q2; // Helper queue for push operations

	public QueueStack() {
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}

	// Push operation (O(N) time complexity)
	public void push(String element) {
		// Add the new element to q2
		q2.offer(element);

	
		// Move all elements from q1 to q2
		while (!q1.isEmpty()) {
			q2.offer(q1.poll());
		}

		// Swap the references of q1 and q2
		// Now q1 contains the new element at the front, followed by older elements
		Queue<String> temp = q1;
		System.err.println(temp.size());
		q1 = q2;
		q2 = temp;
	}

	// Pop operation (O(1) time complexity)
	public String pop() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		return q1.poll();
	}

	// Top operation (O(1) time complexity)
	public String peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		return q1.peek();
	}

	// Empty check (O(1) time complexity)
	public boolean isEmpty() {
		return q1.isEmpty();
	}

	// Size operation (O(1) time complexity)
	public int size() {
		return q1.size();
	}

}

public class Scenario26_Stack_Using_Queues {
	public static void main(String[] args) {
		QueueStack stack = new QueueStack();
		stack.push("A");
		stack.push("B");
		stack.push("C");

		System.out.println("Top element: " + stack.peek()); // Expected: C
		System.out.println("Popped element: " + stack.pop()); // Expected: C
		System.out.println("Top element after pop: " + stack.peek()); // Expected: B
		System.out.println("Is stack empty? " + stack.isEmpty()); // Expected: false
		System.out.println("Stack size: " + stack.size()); // Expected: 2
		stack.pop();
		stack.pop();
		System.out.println("Is stack empty? " + stack.isEmpty()); // Expected: true
	}

}
