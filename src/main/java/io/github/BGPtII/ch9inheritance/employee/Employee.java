package io.github.BGPtII.ch9inheritance.employee;

public class Employee {

    private String name;

    public Employee(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double weeklyPay(int hoursWorked) {
        return 0;
    }
}
