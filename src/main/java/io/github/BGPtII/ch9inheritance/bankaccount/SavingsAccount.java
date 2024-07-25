package io.github.BGPtII.ch9inheritance.bankaccount;

public class SavingsAccount extends BankAccount {

    private double interestRate;
    private double minimumBalance;

    public SavingsAccount(double balance, double interestRate, double minimumBalance) {
        super(balance);
        if (interestRate < 0 || minimumBalance < 0) {
            throw new IllegalArgumentException("interestRate & minimumBalance must be greater than or equal to 0.");
        }
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
    }

    public SavingsAccount() {
        super();
        interestRate = 0;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        double balance = getBalance();
        if (balance < minimumBalance) {
            minimumBalance = balance;
        }
    }

    @Override
    public void monthEnd() {
        double interest = minimumBalance * interestRate / 100;
        deposit(interest);
        minimumBalance = getBalance();
    }
}
