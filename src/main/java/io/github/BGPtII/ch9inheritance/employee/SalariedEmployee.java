package io.github.BGPtII.ch9inheritance.employee;

public class SalariedEmployee extends Employee {

    private double annualSalary;

    public SalariedEmployee(String name, double annualSalary) {
        super(name);
        if (annualSalary <= 0) {
            throw new IllegalArgumentException("salary must be greater than 0.");
        }
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public double weeklyPay(int hoursWorked) {
        final int WEEKS_PER_YEAR = 52;
        return annualSalary / WEEKS_PER_YEAR;
    }
}
