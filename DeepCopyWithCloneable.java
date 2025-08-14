package com.jpa.sample;
class Address implements Cloneable {
    private String street;

    public Address(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public Address clone() {
        try {
            return (Address) super.clone(); // Shallow copy, fine for primitives & Strings
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Should never happen
        }
    }

    @Override
    public String toString() {
        return street;
    }
}

class Person implements Cloneable {
    private String name;
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // Override clone() for deep copy
    @Override
    public Person clone() {
        try {
            Person cloned = (Person) super.clone(); // Shallow copy first
            cloned.address = address.clone();       // Then deep copy Address
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', address=" + address + "}";
    }
}

public class DeepCopyWithCloneable {
    public static void main(String[] args) {
        // Original object
        Person originalPerson = new Person("John", new Address("123 Main St"));

        // Deep copy using clone()
        Person deepCopyPerson = originalPerson.clone();

        // Modify the deep copy
        deepCopyPerson.setName("Jane");
        deepCopyPerson.getAddress().setStreet("456 Side St");

        // Print results
        System.out.println("Original Person: " + originalPerson);
        System.out.println("Deep Copy Person: " + deepCopyPerson);
    }
}
