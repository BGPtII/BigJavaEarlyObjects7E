package io.github.BGPtII.ch15javacollectionsframework;

import java.util.Objects;

public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("balance can't be < 0.");
        }
        this.balance = balance;
    }

    public BankAccount() {
        balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Can't deposit an amount < 0.");
        }
        balance += amount;
    }

    /**
     * Does not allow going into overdraft (balance < 0)
     * @param amount the amount to withdraw
     * @return the amount
     */
    public double withdraw(double amount) {
        if (balance - amount < 0) {
            return 0;
        }
        balance -= amount;
        return amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BankAccount bA = (BankAccount) obj;
        return getBalance() == bA.getBalance();
    }

    @Override
    public String toString() {
        return "BankAccount{balance=" + balance + "}";
    }

}
