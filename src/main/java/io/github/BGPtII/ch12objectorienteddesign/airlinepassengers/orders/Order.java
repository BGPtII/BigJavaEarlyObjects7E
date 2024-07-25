package io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.orders;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private Map<OrderItem, Integer> orderItemToQuantity;
    private double totalCost;

    public Order() {
        orderItemToQuantity = new HashMap<>();
        totalCost = 0;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void addOrderItem(OrderItem orderItem, int quantity) {
        orderItemToQuantity.put(orderItem, orderItemToQuantity.getOrDefault(orderItem, 0) + quantity);
        totalCost += orderItem.getPrice() * quantity;
    }

    public void removeOrderItem(OrderItem orderItem, int quantity) {
        if (!orderItemToQuantity.containsKey(orderItem)) {
            throw new IllegalArgumentException("orderItemToQuantity must contain orderItem to remove it.");
        }
        int currentQuantity = orderItemToQuantity.get(orderItem);
        if (currentQuantity <= quantity) {
            orderItemToQuantity.remove(orderItem);
        }
        else {
            orderItemToQuantity.replace(orderItem, currentQuantity - quantity);
        }
        if (orderItemToQuantity.containsKey(orderItem)) {
            totalCost -= orderItem.getPrice() * quantity;
        }
        else {
            totalCost -= orderItem.getPrice() * currentQuantity;
        }
    }

}
