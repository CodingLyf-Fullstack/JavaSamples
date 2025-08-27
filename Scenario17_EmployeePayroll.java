package com.sample;

//Abstract class with common fields and behavior
abstract class Employee {
 protected String name;
 protected double salary;

 public Employee(String name, double salary) {
     this.name = name;
     this.salary = salary;
 }

 // Abstract method — subclasses must implement their own bonus logic
 public abstract double calculateBonus();

 public void displayInfo() {
     System.out.println("Name: " + name + ", Salary: " + salary);
 }
}

//Full-time employee with its own bonus calculation
class FullTimeEmployee extends Employee {
 public FullTimeEmployee(String name, double salary) {
     super(name, salary);
 }

 @Override
 public double calculateBonus() {
     return salary * 0.2; // 20% bonus
 }
}

//Contract employee with a different bonus calculation
class ContractEmployee extends Employee {
 public ContractEmployee(String name, double salary) {
     super(name, salary);
 }

 @Override
 public double calculateBonus() {
     return salary * 0.1; // 10% bonus
 }
}

public class Scenario17_EmployeePayroll {
 public static void main(String[] args) {
     Employee emp1 = new FullTimeEmployee("NTR", 50000);
     Employee emp2 = new ContractEmployee("Hrithik ", 40000);

     emp1.displayInfo();
     System.out.println("Bonus: " + emp1.calculateBonus());

     emp2.displayInfo();
     System.out.println("Bonus: " + emp2.calculateBonus());
     


     
     

 }
}
