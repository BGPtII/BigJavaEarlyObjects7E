package io.github.BGPtII.ch3implementingclasses;

public class Employee {
    private String employeeName;
    private double currentSalary;

    public Employee(String employeeName, double currentSalary) {
        this.employeeName = employeeName;
        this.currentSalary = currentSalary;
    }

    public String getName() { return employeeName; }

    public double getSalary() { return currentSalary; }

    public void raiseSalary(double byPercent) {
        currentSalary *= (1 + (byPercent / 100.0));
    }
}
