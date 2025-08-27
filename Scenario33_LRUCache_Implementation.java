package com.sample;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        // initialCapacity, loadFactor, accessOrder
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity; // Evict when over capacity
    }
}

public class Scenario33_LRUCache_Implementation {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        System.out.println(cache); // {1=One, 2=Two, 3=Three}

        cache.get(1); // Access 1, moves it to most recent
        cache.get(3); // Access 3, moves it to most recent
        cache.put(4, "Four"); // This statement removes least recently used (key 2)

        System.out.println(cache); // {3=Three, 1=One, 4=Four}
    }
}
