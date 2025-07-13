package com.example.demo;

class Engine {
    public void start() {
        System.out.println("Engine started.");
    }

    public void stop() {
        System.out.println("Engine stopped.");
    }
}

class Car {
    private Engine engine; // Composition: Car "has-a" Engine

    public Car() {
        this.engine = new Engine(); // Engine created within the Car's lifetime
    }

    public void startCar() {
        engine.start();
        System.out.println("Car is ready to drive.");
    }

    public void stopCar() {
        engine.stop();
        System.out.println("Car is parked.");
    }
}

public class CompositionDemo {
	public static void main(String[] args) {
        Car myCar = new Car();

        myCar.startCar(); // Start the engine
        myCar.stopCar(); // Stop the engine
    }
}
