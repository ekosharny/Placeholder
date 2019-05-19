package com.example.placeholder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.placeholder.Database.Details;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
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

        redvelvetcake = "Red Velvet Cheesecake";
        chocolatecake = "Chocolate Cheesecake";
        strawberrycake  = "Strawberry Swirl Cheesecake";
        blueberrycake = "Blueberry CheeseCake";
        toffeecake = "Toffee Cheesecake";
        pbcake = "Peanut Butter CheeseCake";
        chocolatechip = "Chocolate Chip Cookie";
        oatmealraisin = "Oatmeal Raisin Cookie";
        pbcookie = "Peanut Butter Cookie";
        macadamia = "Macadamia Nut Cookie";
        redvelvetcupcake = "Red Velvet Cupcake";
        chocolatecupcake = "Chocolate Cupcake";
        vanillacupcake = "Vanilla Sprinkle Cupcake";

        addToCart = findViewById(R.id.addDessertsButton);

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                if (user != null ) {
                    String e = user.getEmail();

                    if (redvelvetcakeb.isChecked()) {
                        Details details = new Details(1, redvelvetcake, cakeprice, e);
                        AddData(details);
                    }
                    if (chocolatecakeb.isChecked()) {
                        Details details = new Details(1, chocolatecake, cakeprice, e);
                        AddData(details);
                    }
                    if (strawberrycakeb.isChecked()) {
                        Details details = new Details(1, strawberrycake, cakeprice, e);
                        AddData(details);
                    }
                    if (blueberrycakeb.isChecked()) {
                        Details details = new Details(1, blueberrycake, cakeprice, e);
                        AddData(details);
                    }
                    if (toffeecakeb.isChecked()) {
                        Details details = new Details(1, toffeecake, cakeprice, e);
                        AddData(details);
                    }
                    if (pbcakeb.isChecked()) {
                        Details details = new Details(1, pbcake, cakeprice, e);
                        AddData(details);
                    }
                    if (chocolatechipb.isChecked()) {
                        Details details = new Details(1, chocolatechip, cookieprice, e);
                        AddData(details);
                    }
                    if (oatmealraisinb.isChecked()) {
                        Details details = new Details( 1, oatmealraisin, cookieprice, e);
                        AddData(details);
                    }
                    if (pbcookieb.isChecked()) {
                        Details details = new Details(1, pbcookie, cookieprice, e);
                        AddData(details);
                    }
                    if (macadamiab.isChecked()) {
                        Details details = new Details(1, macadamia, cookieprice, e);
                        AddData(details);
                    }
                    if (redvelvetcupcakeb.isChecked()) {
                        Details details = new Details(1, redvelvetcupcake, cupcakeprice, e);
                        AddData(details);
                    }
                    if (chocolatecupcakeb.isChecked()) {
                        Details details = new Details(1, chocolatecupcake, cupcakeprice, e);
                        AddData(details);
                    }
                    if (vanillacupcakeb.isChecked()) {
                        Details details = new Details(1, vanillacupcake, cupcakeprice, e);
                        AddData(details);
                    }
                }
            }
        });

    }

    public void AddData(Details details) {

        //creates new databasehelper and calls addHandler which adds the customer to the database
        DatabaseHelper dbHandler = new DatabaseHelper(this);
        dbHandler.addDetails(details);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
