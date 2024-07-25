package io.github.BGPtII.ch8designingclasses;

public class BankAccount {

    public enum AccountType {
        SAVINGS,
        CHECKING
    }

    private double savingsAmount;
    private double checkingAmount;

    public BankAccount(double savingsAmount, double checkingAmount) {
        if (savingsAmount < 0 || checkingAmount < 0) {
            throw new IllegalArgumentException("savingsAmount or checkingAmount cannot be less than 0 while initializing the BankAccount.");
        }
        else if (savingsAmount == 0 && checkingAmount == 0) {
            throw new IllegalArgumentException("savingsAmount & checkingAmount cannot both be 0 while initializing the BankAccount.");
        }
        this.savingsAmount = savingsAmount;
        this.checkingAmount = checkingAmount;
    }

    public double withdrawSavings(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount cannot be less than or equal to 0.");
        }
        this.savingsAmount -= amount;
        return amount;
    }

    public double withdraw(double amount, AccountType accountType) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount cannot be less than or equal to 0.");
        }
        switch (accountType) {
            case CHECKING -> this.checkingAmount -= amount;
            case SAVINGS -> this.savingsAmount -= amount;
        }
        return amount;
    }

    public void deposit(double amount, AccountType accountType) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount cannot be less than or equal to 0.");
        }
        switch (accountType) {
            case CHECKING -> this.checkingAmount += amount;
            case SAVINGS -> this.savingsAmount += amount;
        }
    }

    public void transfer(BankAccount bankAccount, double amount, AccountType accountTypeTo, AccountType accountTypeFrom) {
        switch (accountTypeFrom) {
            case SAVINGS -> this.savingsAmount -= amount;
            case CHECKING -> this.checkingAmount -= amount;
        }
        switch (accountTypeTo) {
            case SAVINGS -> bankAccount.savingsAmount += amount;
            case CHECKING -> bankAccount.checkingAmount += amount;
        }
    }

}
