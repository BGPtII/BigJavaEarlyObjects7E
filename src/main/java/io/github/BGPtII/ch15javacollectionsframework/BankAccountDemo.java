package io.github.BGPtII.ch15javacollectionsframework;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Random;

public class BankAccountDemo {

    private static final DecimalFormat dF = new DecimalFormat("0.00");

    public static void main(String[] args) {
        Random generator = new Random();
        HashSet<BankAccount> bankAccounts = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            double balance = Double.parseDouble(dF.format(generator.nextDouble() * 100.0));
            BankAccount bankAccount = new BankAccount(balance);
            System.out.println("Balance: " + balance + ", HashCode: " + bankAccount.hashCode());
            bankAccounts.add(bankAccount);
        }
        System.out.println("Total unique bank accounts: " + bankAccounts.size());
    }
}
