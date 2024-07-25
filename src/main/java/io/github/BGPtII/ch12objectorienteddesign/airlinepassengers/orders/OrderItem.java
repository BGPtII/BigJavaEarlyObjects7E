package io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.orders;

abstract public class OrderItem {

    private String name;
    private double price;
    private OrderItemType orderItemType;

    public OrderItem(String name, double price, OrderItemType orderItemType) {
        this.name = name;
        this.price = price;
        this.orderItemType = orderItemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderItemType getOrderItemType() {
        return orderItemType;
    }

    public void setOrderItemType(OrderItemType orderItemType) {
        this.orderItemType = orderItemType;
    }

}
