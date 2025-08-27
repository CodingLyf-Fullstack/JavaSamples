package com.sample;

public class Scenario49_ArrayQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int currentSize;

    /**
     * .
     * Here's how it works:
     *
     * 1. enqueue(int item) 
     *    - Adds an element to the rear of the queue.
     *    - If the queue is full, it prints a message and does not add the element.
     *    - Uses circular increment for the rear index.
     *    	rear = (rear + 1) % capacity;
				1.	rear + 1 moves the rear pointer to the next position in the array.
				2.	% capacity ensures that if rear reaches the last index (capacity - 1), it comes back to 0.
     *
     * 2. dequeue()
     *    - Removes and returns the element at the front of the queue.
     *    - If the queue is empty, it prints a message and returns -1.
     *    - Uses circular increment for the front index.
     *
     * 3. peek()
     *    - Returns the element at the front without removing it.
     *    - If the queue is empty, it prints a message and returns -1.
     *
     * 4. isEmpty()
     *    - Checks if the queue has no elements.
     *
     * 5. isFull()
     *    - Checks if the queue has reached its capacity.
     *
     * 6. size()
     *    - Returns the current number of elements in the queue.
     *
     * The constructor initializes the queue with a given capacity, 
     * sets front and rear pointers, and sets the current size to 0.
     */
    public Scenario49_ArrayQueue(int size) {
        this.capacity = size;
        arr = new int[capacity];
        System.err.println(capacity);
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    // Enqueue operation: adds an element to the rear of the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + item);
            return;
        }
        rear = (rear + 1) % capacity; // Circular increment for rear
        arr[rear] = item;
        currentSize++;
        System.out.println(item + " enqueued to queue"+" "+rear);
    }

    // Dequeue operation: removes and returns the element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Or throw an exception
        }
        int item = arr[front];
        front = (front + 1) % capacity; // Circular increment for front
        currentSize--;
        System.out.println(item + " dequeued from queue"+" "+front);
        return item;
    }

    // Peek operation: returns the element at the front without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1; // Or throw an exception
        }
        return arr[front];
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Checks if the queue is full
    public boolean isFull() {
        return currentSize == capacity;
    }

    // Returns the current size of the queue
    public int size() {
        return currentSize;
    }

    public static void main(String[] args) {
        Scenario49_ArrayQueue queue = new Scenario49_ArrayQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println("Front element is: " + queue.peek());

        queue.dequeue();
        queue.dequeue();

        queue.enqueue(50);
        queue.enqueue(60); // Comment dequeue() methods to check, This will show "Queue is full" if capacity is 5
//        queue.enqueue(70); // This will also show "Queue is full"
//

    }
}