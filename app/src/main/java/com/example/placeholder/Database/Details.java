package com.example.placeholder.Database;

public class Details {
    private int orderID;
    private String item;
    private double price;

    public Details(){}

    public Details(int orderID, String item, double price) {
        this.orderID = orderID;
        this.item = item;
        this.price=price;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {

        this.orderID = orderID;
    }

    public String getItemName() {

        return item;
    }

    public void setItemName(String item) {

        this.item = item;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }
}
