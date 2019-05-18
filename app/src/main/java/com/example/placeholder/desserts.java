package com.example.placeholder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;

public class desserts extends AppCompatActivity {

    Button addToCart;

    CheckBox redvelvetcakeb, chocolatecakeb, strawberrycakeb, blueberrycakeb, toffeecakeb, pbcakeb;
    CheckBox chocolatechipb, oatmealraisinb, pbcookieb, macadamiab;
    CheckBox redvelvetcupcakeb, chocolatecupcakeb, vanillacupcakeb;

    String redvelvetcake, chocolatecake, strawberrycake, blueberrycake, toffeecake, pbcake;
    String chocolatechip, oatmealraisin, pbcookie, macadamia;
    String redvelvetcupcake, chocolatecupcake, vanillacupcake;

    final double cakeprice=4.00, cookieprice=1.50, cupcakeprice=2.50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desserts);

        redvelvetcakeb = findViewById(R.id.redvelvetcakeButton);
        chocolatecakeb = findViewById(R.id.chocolatecakeButton);
        strawberrycakeb  = findViewById(R.id.strawberryswirlButton);
        blueberrycakeb = findViewById(R.id.blueberrycakeButton);
        toffeecakeb = findViewById(R.id.toffeeButton);
        pbcakeb = findViewById(R.id.pbcakeButton);
        chocolatechipb = findViewById(R.id.chocolatechipButton);
        oatmealraisinb = findViewById(R.id.oatmealraisinButton);
        pbcookieb = findViewById(R.id.pbcookieButton);
        macadamiab = findViewById(R.id.macadamiaButton);
        redvelvetcupcakeb = findViewById(R.id.redvelvetcupcakeButton);
        chocolatecupcakeb = findViewById(R.id.chocolatecupcakeButton);
        vanillacupcakeb = findViewById(R.id.vanillacupcakeButton);

        redvelvetcake = findViewById(R.id.redvelvetcakeButton).toString();
        chocolatecake = findViewById(R.id.chocolatecakeButton).toString();
        strawberrycake  = findViewById(R.id.strawberryswirlButton).toString();
        blueberrycake = findViewById(R.id.blueberrycakeButton).toString();
        toffeecake = findViewById(R.id.toffeeButton).toString();
        pbcake = findViewById(R.id.pbcakeButton).toString();
        chocolatechip = findViewById(R.id.chocolatechipButton).toString();
        oatmealraisin = findViewById(R.id.oatmealraisinButton).toString();
        pbcookie = findViewById(R.id.pbcookieButton).toString();
        macadamia = findViewById(R.id.macadamiaButton).toString();
        redvelvetcupcake = findViewById(R.id.redvelvetcupcakeButton).toString();
        chocolatecupcake = findViewById(R.id.chocolatecupcakeButton).toString();
        vanillacupcake = findViewById(R.id.vanillacupcakeButton).toString();

        addToCart = findViewById(R.id.addItemsButton);

    }
}
