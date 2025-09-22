package com.jpa.sample;

/**
 * Traffic Light Decision System
 *
 * This program decides what action a driver should take based on the traffic light color
 * and additional conditions:
 * 1. RED     > Always Stop.
 * 2. YELLOW  > If pedestrian is waiting, Stop for crossing, else Slow down.
 * 3. GREEN   > If emergency vehicle is present, Give way, else Go.
 *
 * The solution uses a switch statement for lightColor and nested if-else for conditions.
 */

public class Scenario3_TrafficLightActions {
    public static void main(String[] args) {
        String lightColor = "YELLOW";   // Can be RED, YELLOW, GREEN
        boolean pedestrianWaiting = true;
        boolean emergencyVehicle = false;

        switch (lightColor) {
            case "RED":
                System.out.println("Stop");
                break;

            case "YELLOW":
                if (pedestrianWaiting) {
                    System.out.println("Stop, pedestrian crossing");
                } else {
                    System.out.println("Slow down");
                }
                break;

            case "GREEN":
                if (emergencyVehicle) {
                    System.out.println("Give way to emergency vehicle");
                } else {
                    System.out.println("Go");
                }
                break;

            default:
                System.out.println("Invalid light color");
        }
    }
}

