package io.github.BGPtII.ch9inheritance.employee;

public class Manager extends SalariedEmployee {

    private double weeklyBonus;

    public Manager(String name, double salary, double weeklyBonus) {
        super(name, salary);
        if (weeklyBonus <= 0) {
            throw new IllegalArgumentException("bonus must be greater than 0.");
        }
        this.weeklyBonus = weeklyBonus;
    }

    public double getWeeklyBonus() {
        return weeklyBonus;
    }

    public void setWeeklyBonus(double weeklyBonus) {
        this.weeklyBonus = weeklyBonus;
    }

    public double weeklyPay(int hoursWorked) {
        if (hoursWorked <= 0) {
            throw new IllegalArgumentException("hoursWorked can't be 0 or less than 0.");
        }
        return super.weeklyPay(hoursWorked) + weeklyBonus;
    }
}
