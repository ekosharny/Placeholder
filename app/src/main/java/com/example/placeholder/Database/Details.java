package com.example.placeholder.Database;

public class Details {
    private int orderID;
    private String item;
    private double price;
    private String email;

    public Details(){}

    public Details(int orderID, String item, double price, String email) {
        this.orderID=orderID;
        this.item = item;
        this.price=price;
        this.email=email;
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
    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }
}
