package io.github.BGPtII.ch10interfaces;

import java.util.ArrayList;

public class Bag {

    private ArrayList<Item> items;

    public Bag() {
        items = new ArrayList<>();
    }

    private class Item {
        private String name;
        private int quantity;

        private Item(String name) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("name can't be empty.");
            }
            this.name = name;
            quantity = 1;
        }

    }

    private void addItem(String itemName) {
        if (itemName.isEmpty()) {
            throw new IllegalArgumentException("itemName can't be empty.");
        }
        for (Item item : items) {
            if (item.name.equals(itemName)) {
                item.quantity++;
                return;
            }
        }
        items.add(new Item(itemName));
    }

    private int count(String itemName) {
        for (Item item : items) {
            if (item.name.equals(itemName)) {
                return item.quantity;
            }
        }
        return 0;
    }
}
