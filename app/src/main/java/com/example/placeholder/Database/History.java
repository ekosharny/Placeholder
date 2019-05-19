package com.example.placeholder.Database;

public class History {
    private String UID;
    private String item;
    private double price;
    private int orderID;

    public History(){}

    public History(String UID, String item, double price, int orderID) {
        this.UID = UID;
        this.item = item;
        this.price=price;
        this.orderID=orderID;
    }

    public String getUID(){return UID;}
    public void setUID(String UID){
        this.UID=UID;
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
