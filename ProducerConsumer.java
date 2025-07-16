package com.example.demo.threads;

class SharedResource {
	boolean isDataAvailable = false;

	public synchronized void produce(int i) throws InterruptedException {

		if (isDataAvailable) {
			wait();
		}
		System.out.println("Produced " + i);
		isDataAvailable = true;
		notify();
	}

	public synchronized void consumer(int i) throws InterruptedException {

		if (!isDataAvailable) {
			wait();
		}
		System.out.println("Consumed " + i);
		isDataAvailable = false;
		notify();
	}

}

public class ProducerConsumer {

	public static void main(String[] args) {
		SharedResource resource = new SharedResource();

		Thread t1 = new Thread(() -> {

			for (int i = 0; i < 3; i++) {
				try {
					resource.produce(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		Thread t2 = new Thread(() -> {

			for (int i = 0; i < 3; i++) {
				try {
					resource.consumer(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		
		t1.start();
		t2.start();
	}
}
