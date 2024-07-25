package io.github.BGPtII.ch8designingclasses;

import java.util.HashSet;

public class Customer {

    private double totalPurchases = 0;
    private HashSet<Integer> totalPurchasesShops;

    public Customer() {
        totalPurchases = 0;
        totalPurchasesShops = new HashSet<>();
    }

    public double getTotalPurchases() {
        return totalPurchases;
    }

    public double getNumberOfUniqueShopsPurchasedFrom() {
        return totalPurchasesShops.size();
    }

    public void makePurchase(double amount, int shopNumber) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than 0.");
        }
        if (shopNumber < 1 || shopNumber > 20) {
            throw new IllegalArgumentException("shopNumber must be between 1 & 20 inclusive.");
        }
        if (discountReached()) {
            amount = Math.max(0, amount - 10);
            totalPurchases %= 100;
            totalPurchasesShops.clear();
        }
        totalPurchases += amount;
        totalPurchasesShops.add(shopNumber);
    }

    public boolean discountReached() {
        return totalPurchases >= 100 && totalPurchasesShops.size() >= 3;
    }

}
