package com.example.placeholder;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class ShoppingCart extends AppCompatActivity {
    ArrayList<Item> cart;
    int z;
    ShoppingCart() {

        Item item;
        String itemName;
        int itemPrice;
        z = 0;
        //
        //TODO:SYSTEM INPUT!
        //
        Boolean checkouted = true;
        Cart cart1 = new Cart();
        itemName = "regbowl";

        itemPrice = 8;
        cart1.addToCart(itemName, itemPrice);
    }
}
