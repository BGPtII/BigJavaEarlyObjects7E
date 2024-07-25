package io.github.BGPtII.ch15javacollectionsframework;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Meant for stocks of multiple companies, utilizing a FIFO rule for batches of shares
 */
public class StockTrading {
    private HashMap<String, Queue<Block>> shares;

    public StockTrading() {
        shares = new HashMap<>();
    }

    private void validateInput(String symbol, int quantity, double price) {
        if (symbol == null || symbol.isEmpty()) {
            throw new IllegalArgumentException("Symbol can't be blank or null.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity can't be <= 0.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("price can't be <= 0.");
        }
    }

    /**
     *
     * @param symbol the company's unique identifier on the stock market
     * @param quantity the amount of shares bought
     * @param price the price of each share
     */
    public void buy(String symbol, int quantity, int price) {
        validateInput(symbol, quantity, price);
        shares.putIfAbsent(symbol, new LinkedList<>());
        shares.get(symbol).add(new Block(quantity, price));
    }

    /**
     *
     * @param symbol the company's unique identifier on the stock market
     * @param quantity the amount of shares sold in the current Block
     * @param price the price of each share
     * @return the gain or loss of the transaction
     */
    public double sell(String symbol, int quantity, int price) {
        validateInput(symbol, quantity, price);
        if (!shares.containsKey(symbol) || shares.get(symbol).isEmpty()) {
            throw new IllegalArgumentException("Can't sell, no blocks available for the specified symbol.");
        }
        Queue<Block> stockQueue = shares.get(symbol);
        int stockHeld = 0;
        for (Block block : stockQueue) {
            stockHeld += block.getQuantity();
            if (stockHeld >= quantity) {
                double totalGain = 0;
                while (quantity > 0) {
                    Block currentBlock = stockQueue.peek();
                    int blockQuantity = currentBlock.getQuantity();
                    if (quantity >= blockQuantity) {
                        totalGain += (price - currentBlock.getPrice()) * blockQuantity;
                        quantity -= blockQuantity;
                        stockQueue.remove();
                    }
                    else {
                        totalGain += (price - currentBlock.getPrice()) * blockQuantity;
                        currentBlock.setQuantity(blockQuantity - quantity);
                        quantity = 0;
                    }
                }
                return totalGain;
            }
        }
        throw new IllegalArgumentException("Total stock held for the specified symbol is insufficient for the quantity specified.");
    }

}
