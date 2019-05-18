package com.example.placeholder.Database;

public class Details {
    private int orderID;
    private String itemName;
    private double price;

    public Details(int orderID, String itemName, double price) {
        this.orderID = orderID;
        this.itemName = itemName;
        this.price = price;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
