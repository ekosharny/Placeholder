package com.example.placeholder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;

public class drinks extends AppCompatActivity {

     Button addToCart;

     CheckBox cocacolab, pepsib, mountaindewb, spriteb, fantab;
     CheckBox applejb, cranberryjb, orangejb, lemonadeb, pineapplejb;
     CheckBox greekyogurtb, wholemilkb, almondmilkb, soymilkb, coconutmilkb;
     CheckBox appleb, bananab, orangeb, strawberriesb, blueberriesb;

     String cocacola, pepsi, mountaindew, sprite, fanta;
     String applej, cranberryj, orangej, lemonade, pineapplej;
     String greekyogurt, wholemilk, almondmilk, soymilk, coconutmilk;
     String apple, banana, orange, strawberries, blueberries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        cocacolab = findViewById(R.id.cocacolaButton);
        pepsib = findViewById(R.id.pepsiButton);
        mountaindewb  = findViewById(R.id.mountaindewButton);
        spriteb  = findViewById(R.id.spriteButton);
        fantab = findViewById(R.id.fantaButton);
        applejb  = findViewById(R.id.applejButton);
        cranberryjb = findViewById(R.id.cranberryjButton);
        orangejb = findViewById(R.id.orangejButton);
        lemonadeb = findViewById(R.id.lemonadeButton);
        pineapplejb = findViewById(R.id.pineapplejButton);
        greekyogurtb = findViewById(R.id.greekyogurtButton);
        wholemilkb = findViewById(R.id.wholemilkButton);
        almondmilkb = findViewById(R.id.almondMilkButton);
        soymilkb = findViewById(R.id.soymilkButton);
        coconutmilkb = findViewById(R.id.coconutmilkButton);
        appleb = findViewById(R.id.appleButton);
        bananab = findViewById(R.id.bananaButton);
        orangeb = findViewById(R.id.orangeButton);
        strawberriesb = findViewById(R.id.strawberriesButton);
        blueberriesb = findViewById(R.id.blueberriesButton);

        cocacola = findViewById(R.id.cocacolaButton).toString();
        pepsi = findViewById(R.id.pepsiButton).toString();
        mountaindew  = findViewById(R.id.mountaindewButton).toString();
        sprite  = findViewById(R.id.spriteButton).toString();
        fanta = findViewById(R.id.fantaButton).toString();
        applej  = findViewById(R.id.applejButton).toString();
        cranberryj = findViewById(R.id.cranberryjButton).toString();
        orangej = findViewById(R.id.orangejButton).toString();
        lemonade = findViewById(R.id.lemonadeButton).toString();
        pineapplej = findViewById(R.id.pineapplejButton).toString();
        greekyogurt = findViewById(R.id.greekyogurtButton).toString();
        wholemilk = findViewById(R.id.wholemilkButton).toString();
        almondmilk = findViewById(R.id.almondMilkButton).toString();
        soymilk = findViewById(R.id.soymilkButton).toString();
        coconutmilk = findViewById(R.id.coconutmilkButton).toString();
        apple = findViewById(R.id.appleButton).toString();
        banana = findViewById(R.id.bananaButton).toString();
        orange = findViewById(R.id.orangeButton).toString();
        strawberries = findViewById(R.id.strawberriesButton).toString();
        blueberries = findViewById(R.id.blueberriesButton).toString();

        addToCart = findViewById(R.id.addItemsButton);

    }
}
