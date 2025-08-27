package com.sample;

import java.util.LinkedList;
import java.util.Queue;

class SharedQueue {

	Queue<Integer> queue = new LinkedList<Integer>();
	final int CAPACITY = 10;

	public synchronized void produce(int i) throws InterruptedException {

		if (queue.size() == 10) {
			wait();
		}
		queue.offer(i);
		System.out.println("Produced " + i);
		notify();

	}

	public synchronized void consume() throws InterruptedException {

		if (queue.size() == 0) {
			wait();
		}
		int value = queue.poll();
		System.out.println("Consumed " + value);
		notify();

	}

}

public class Scenario8_ProducerConsumer {

	public static void main(String[] args) {
		SharedQueue resource = new SharedQueue();

		Thread t1 = new Thread(() -> {
			int value = 0;
			while (value <= 20) {
				try {
					resource.produce(value++);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		Thread t2 = new Thread(() -> {

			try {
				while (resource.queue.size() > 0) {
					resource.consume();
					Thread.sleep(1000); // Simulate consumption time
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}

		});

		t1.start();
		t2.start();
	}
}

