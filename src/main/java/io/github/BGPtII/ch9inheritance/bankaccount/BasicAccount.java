package io.github.BGPtII.ch9inheritance.bankaccount;

public class BasicAccount extends BankAccount {

    public BasicAccount() {
        super();
    }

    public BasicAccount(double amount) {
        super(amount);
    }

    @Override
    public void withdraw(double amount) {
        final int OVERDRAFT_FEE = 30;
        super.withdraw(amount);
        if (getBalance() < 0) {
            super.withdraw(30);
        }

    }
}
