package com.example.demo;


class Address {
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
    public String toString() {
        return street;
    }
}

class Person {
    private String name;
    private Address address;
    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Copy constructor for shallow copy
    public Person(Person other) {
        this.name = other.name;         // String is immutable, so it's safe
        this.address = other.address;   // Still references the same Address object
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

	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + "]";
	}

	
}

public class ShallowCopyExample {
    public static void main(String[] args) {
        // Original object
        Person originalPerson = new Person("John", new Address("Jubliee Hills"));

        // Shallow copy using copy constructor
        Person shallowCopyPerson = new Person(originalPerson);

        // Modifying the shallow copy
        shallowCopyPerson.setName("Jane");
        shallowCopyPerson.getAddress().setStreet("Madhapur");

        //Name is unchanged in Original Object but Address is changed
        System.out.println("Original Person: " + originalPerson); 
        System.out.println("Shallow Copy Person: " + shallowCopyPerson);
    }
}

