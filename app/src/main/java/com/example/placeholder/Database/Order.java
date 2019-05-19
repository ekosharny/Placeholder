package com.example.placeholder.Database;

public class Order {
    private String email;
    private String orders;

    public Order(){}

    public Order(String email, String orders) {
        this.email = email;
        this.orders = orders;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }
}