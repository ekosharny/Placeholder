package com.example.placeholder;
import java.text.NumberFormat;

public class Item {
    private String name;
    private double price;

    //Create a new item with the given attributes.
    public Item( String itemName, double itemPrice){
        name=itemName;
        price=itemPrice;

    }
    //   Return a string with the information about the item

    public String toString ()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        return (name + "\t" + fmt.format(price));
    }

    //   Returns the unit price of the item
    public double getPrice()
    {
        return price;
    }
}
