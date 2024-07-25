package io.github.BGPtII.ch9inheritance.bankaccount;

public class BankAccount {

    private double balance;

    public BankAccount() {
        this.balance = 0;
    }

    public BankAccount(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("balance must be greater than or equal to 0.");
        }
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater 0.");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater 0.");
        }
        this.balance -= amount;
    }

    public void monthEnd() {

    }

    public double getBalance() {
        return balance;
    }
}
