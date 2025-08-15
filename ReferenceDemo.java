package com.jpa.sample;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceDemo {
    public static void main(String[] args) {
        // Example object
        String strongObj = new String("I am a Strong Reference");

        // SoftReference example
        SoftReference<String> softRef = new SoftReference<>(new String("I am a Soft Reference"));

        // WeakReference example
        WeakReference<String> weakRef = new WeakReference<>(new String("I am a Weak Reference"));

        // Strong reference stays alive
        System.out.println("Strong Reference before GC: " + strongObj);

        // Before GC
        System.out.println("Soft Reference before GC: " + softRef.get());
        System.out.println("Weak Reference before GC: " + weakRef.get());

        // Hint GC to run
        System.gc();
        System.runFinalization();

        // After GC
        System.out.println("\nAfter GC:");
        System.out.println("Strong Reference after GC: " + strongObj);
        System.out.println("Soft Reference after GC: " + softRef.get()); // may still be there
        System.out.println("Weak Reference after GC: " + weakRef.get()); // likely gone
    }
}
