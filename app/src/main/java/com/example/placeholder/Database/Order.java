package com.example.placeholder.Database;

public class Order {
    private int orderID;
    private String uID;

    public Order(){}

    public Order(int orderID, String uID) {
        this.orderID = orderID;
        this.uID = uID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }
}
