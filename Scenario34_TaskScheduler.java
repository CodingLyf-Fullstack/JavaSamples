package com.sample;

import java.util.PriorityQueue;

class Job {
    String name;
    int priority;

    Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}
public class Scenario34_TaskScheduler {
    public static void main(String[] args) {
        // Max-heap style: highest priority first
        PriorityQueue<Job> queue = new PriorityQueue<>(
            (j1, j2) -> Integer.compare(j2.priority, j1.priority)
        );

        queue.add(new Job("Email Report", 2));
        queue.add(new Job("Database Backup", 5));
        queue.add(new Job("UI Refresh", 3));

        while (!queue.isEmpty()) {
            Job job = queue.poll();
            System.out.println("Executing: " + job);
        }
    }
}
