package io.github.BGPtII.ch3implementingclasses;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee test = new Employee("Fname, Lname", 50000);

        System.out.println("Employee name: expected - \"Fname, Lname\", actual - " + test.getName());

        test.raiseSalary(20);
        System.out.println("After raising salary by 20%:");
        System.out.println("Expected salary: 60000, Actual salary: " + test.getSalary());
    }
}

