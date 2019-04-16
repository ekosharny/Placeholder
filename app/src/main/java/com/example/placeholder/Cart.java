package com.example.placeholder;
import java.text.NumberFormat;

public class Cart {
    private Item [] order;
    private double totalPrice;
    private int totalCount;

    public Cart(){
        order = new Item[40];
        totalPrice= 0.0;
        totalCount=0;
    }
    public void addToCart(String itemName, double price){
        Item temp= new Item (itemName, price);
        totalPrice+=price;
        order[totalCount]=temp;
        totalCount+=1;
    }
    public Boolean checkout(){

        //TODO money checkout
        if((totalPrice==0)&&(totalCount==0)){
            return true;
        }
        else return false;
    }
}
