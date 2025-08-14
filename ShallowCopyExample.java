package com.jpa.sample;

import java.util.Stack;

//public class Main {
//	public static void main(String[] args) {
//
//		System.err.println(isBalanced("{[()]}"));
//		System.err.println(isBalanced("{[(])}"));
//	}
//
//	static boolean isBalanced(String str) {
//		Stack<Character> stack = new Stack<>();
//		for (Character ch : str.toCharArray()) {
//			if (ch == '(' || ch == '{' || ch == '[') {
//				stack.push(ch);
//			} else if (ch == ')' || ch == '}' || ch == ']') {
//				{
//					if (stack.isEmpty())
//						return false;
//					Character top = stack.pop();
//					if (ch == ')' && top != '(' || ch == '}' && top != '{' || ch == ']' && top != '[') {
//						return false;
//					}
//				}
//
//			}
//		}
//		return stack.isEmpty();
//	}
//}

class Cloning  {
    private int[] data;

    public Cloning(int[] values) {
        data = values;
    }

    public void printData() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

//    @Override
//    public Cloning clone() throws CloneNotSupportedException {
//        Cloning cloned = (Cloning) super.clone();
//        cloned.data = data.clone();
//        return cloned;
//    }
}
//public class Main {
//    public static void main(String[] args) {
//        int[] values = {1, 2, 3, 4, 5};
//        Cloning obj1 = new Cloning(values);
//        
//        int a = 10;
//        int b = a;
//        b = 20;
//        
//        System.err.println(a);
//
//        try {
////            Cloning obj2 = obj1.clone();
//
//            obj1.printData(); 
////            obj2.printData(); 
//
//            values[0] = 10;
//
//            obj1.printData(); 
////            obj2.printData(); 
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

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

