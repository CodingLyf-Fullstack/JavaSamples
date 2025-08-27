package com.sample;


public class Scenario50_CustomHashMap<K, V> {

    // Default number of buckets. Each bucket can hold multiple entries (chained in a linked list).
    private int capacity = 16;

    // The array of buckets. Each bucket stores linked list of entries (key-value pairs).
    private Entry<K, V> buckets[];

    /**
     * Constructor:
     * When we create a new map, it allocates an array of 16 buckets.
     * Initially, all buckets are null (empty).
     */
    public Scenario50_CustomHashMap() {
        this.buckets = new Entry[capacity];
    }

    /**
     * put(key, value):
     * This method adds a new key-value pair into the map.
     * Steps:
     * 1. Convert the key into a hash using hashCode().
     * 2. Find the bucket index by taking modulo with bucket size.
     * 3. If the bucket is empty, place the new entry there.
     * 4. If bucket is not empty, walk through the linked list inside the bucket:
     *      - If the key already exists, update its value.
     *      - If not, add the new entry at the end of the list.
     */
    public void put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value, null);

        int index = getHash(key) % getBucketSize();
        Entry<K, V> current = buckets[index];

        if (current == null) {
            // No collision -> directly insert
            buckets[index] = entry;
        } else {
            // Collision -> go through the linked list at this bucket
            while (current.next != null) {
                // If key is already present, update value
                if (current.getKey().equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }

            // Check last element for same key
            if (current.getKey().equals(key)) {
                current.value = value;
            } else {
                // Otherwise, add new entry at the end
                current.next = entry;
            }
        }
    }

    /**
     * get(key):
     * This method fetches the value for a given key.
     * Steps:
     * 1. Convert key into hash.
     * 2. Find the correct bucket using modulo.
     * 3. Walk through linked list in that bucket:
     *      - If key matches, return its value.
     *      - If not found, return null.
     */
    public V get(K key) {
        int index = getHash(key) % getBucketSize();
        Entry<K, V> current = buckets[index];

        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Key not found
    }

    /**
     * remove(key):
     * This method removes the entry for a given key.
     * Steps:
     * 1. Convert key into hash.
     * 2. Find the correct bucket.
     * 3. Walk through linked list:
     *      - If key found at first node, remove it by pointing bucket to next node.
     *      - If key found in middle, skip it by linking previous node to next node.
     * 4. Return the removed value. If key not found, return null.
     */
    public V remove(K key) {
        int index = getHash(key) % getBucketSize();
        Entry<K, V> current = buckets[index];
        Entry<K, V> previous = null;
        while (current != null) {
            if (current.getKey().equals(key)) {
                if (previous == null) {
                    // Removing first node in bucket
                    buckets[index] = current.next;
                } else {
                    // Removing middle node
                    previous.next = current.next;
                }
                return current.value;
            }
           
            previous = current;
            current = current.next;
        }
        return null; // Key not found
    }

    /**
     * getBucketSize():
     * Returns how many buckets the map currently has.
     * Here it is fixed to 16 (since we are not resizing).
     */
    private int getBucketSize() {
        return this.buckets.length;
    }

    /**
     * getHash(key):
     * Returns a hash number for the key.
     * If key is null, returns 0.
     * Otherwise uses key.hashCode() and takes its absolute value.
     * This ensures that negative hash codes don’t cause issues.
     */
    private int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    /**
     * toString():
     * Helps in printing the internal structure of the map.
     * Goes through all buckets and prints what is inside each one.
     * Useful for debugging and understanding collisions.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getBucketSize(); i++) {
            if (this.buckets[i] != null) {
                sb.append(i + " " + this.buckets[i] + "\n");
            } else {
                sb.append(i + " " + "null" + "\n");
            }
        }
        return sb.toString();
    }

    /**
     * Entry class:
     * Represents a single key-value pair.
     * - key: the identifier
     * - value: the data associated with the key
     * - next: points to the next Entry in the same bucket (to handle collisions)
     */
    private class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        @Override
        public String toString() {
            return "Entry [key=" + key + ", value=" + value + ", next=" + next + "]";
        }
        
    }

    /**
     * main():
     * Demonstrates how our custom map works.
     * - Adds some key-value pairs
     * - Updates values
     * - Retrieves values
     * - Removes a key
     * - Prints map after each operation
     */
    public static void main(String[] args) {
        Scenario50_CustomHashMap<String, String> map = new Scenario50_CustomHashMap<>();

        // Adding values into the map
        map.put("1", "One");
        map.put("2", "Two");
        map.put("3", "Three");
        map.put("4", "Four");
        map.put("17", "Seventeen");
        map.put("33", "Thirtythree");

     // Keys that collide (bucket 1)
        map.put("A", "Letter A");
        map.put("Q", "Letter Q");

        // Keys that collide (bucket 0)
        map.put("Aa", "First");
        map.put("BB", "Second");

        
        // Printing map contents
        System.out.println("Map after adding:");
        System.out.println(map);

        // Fetching a value using key
        System.out.println("Value for key 2: " + map.get("2"));

        // Removing a key
        System.out.println("Removing key 3: " + map.remove("Q"));

        // Printing map again after removal
        System.out.println("Map after removal:");
        System.out.println(map);
    }
}
