package io.github.BGPtII.ch9inheritance.employee;

public class HourlyEmployee extends Employee {

    private double hourlyWage;

    public HourlyEmployee(String name, double hourlyWage) {
        super(name);
        if (hourlyWage <= 0) {
            throw new IllegalArgumentException("hourlyWage must be greater than 0.");
        }
        this.hourlyWage = hourlyWage;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    @Override
    public double weeklyPay(int hoursWorked) {
        if (hoursWorked <= 0) {
            throw new IllegalArgumentException("hoursWorked must be greater than 0.");
        }
        double weeklyPay = hourlyWage * hoursWorked;
        if (hoursWorked > 40) {
            weeklyPay += (hoursWorked - 40) * 0.5 * hourlyWage;
        }
        return weeklyPay;
    }
}
