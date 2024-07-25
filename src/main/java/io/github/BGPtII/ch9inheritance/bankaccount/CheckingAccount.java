package io.github.BGPtII.ch9inheritance.bankaccount;

public class CheckingAccount extends BankAccount {

    private int withdrawalCount;
    private int depositCount;
    private boolean wentIntoOverdraft;
    private final int FREE_TRANSACTIONS = 3;
    private final int TRANSACTION_FEE = 1;

    public CheckingAccount(double balance) {
        super(balance);
        this.withdrawalCount = 0;
        this.depositCount = 0;
        wentIntoOverdraft = false;
    }

    public int getWithdrawalCount() {
        return withdrawalCount;
    }

    @Override
    public void withdraw(double amount) {
        final int FIRST_OVERDRAFT_FEE = 20;

        super.withdraw(amount);
        withdrawalCount++;
        if (withdrawalCount > FREE_TRANSACTIONS) {
            super.withdraw(TRANSACTION_FEE);
        }
        if (getBalance() < 0 && !wentIntoOverdraft) {
            super.withdraw(FIRST_OVERDRAFT_FEE);
            wentIntoOverdraft = true;
        }
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        depositCount++;
        if (depositCount > TRANSACTION_FEE) {
            super.withdraw(TRANSACTION_FEE);
        }
    }

    @Override
    public void monthEnd() {
        withdrawalCount = 0;
        depositCount = 0;
        wentIntoOverdraft = false;
    }

}
