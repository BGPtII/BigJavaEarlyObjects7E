package io.github.BGPtII.ch8designingclasses;

import java.util.HashMap;

public class CashRegister {

    private HashMap<CurrencyDenomination, Integer> currencyDenominationInventory;

    public CashRegister() {
        this.currencyDenominationInventory = new HashMap<>();
    }

    public CashRegister(HashMap<CurrencyDenomination, Integer> currencyDenominationInventory) {
        if (currencyDenominationInventory == null) {
            throw new IllegalArgumentException("currencyDenominationInventory cannot be null.");
        }
        for (CurrencyDenomination currencyDenomination : currencyDenominationInventory.keySet()) {
            if (currencyDenominationInventory.get(currencyDenomination) < 1) {
                throw new IllegalArgumentException("CurrencyDenomination quantities cannot be less than 1.");
            }
        }
        this.currencyDenominationInventory = currencyDenominationInventory;
    }

    public void receivePayment(CurrencyDenomination currencyDenomination, int amount) {
        if (amount > 0) {
            if (currencyDenominationInventory.containsKey(currencyDenomination)) {
                currencyDenominationInventory.replace(currencyDenomination, currencyDenominationInventory.get(currencyDenomination) + amount);
            }
            else {
                currencyDenominationInventory.put(currencyDenomination, amount);
            }
        }
    }

    public int giveChange(CurrencyDenomination currencyDenomination, int amount) {
        if (!currencyDenominationInventory.containsKey(currencyDenomination) || currencyDenominationInventory.get(currencyDenomination) < amount) {
            return 0;
        }
        if (currencyDenominationInventory.get(currencyDenomination) > amount) {
            currencyDenominationInventory.replace(currencyDenomination, currencyDenominationInventory.get(currencyDenomination) - amount);
            return amount;
        }
        currencyDenominationInventory.remove(currencyDenomination);
        return amount;
    }

}
