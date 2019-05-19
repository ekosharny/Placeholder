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

                if (user != null) {
                    String uid = user.getUid();

                    if (redvelvetcakeb.isChecked()) {
                        Details details = new Details(uid, redvelvetcake, cakeprice, 1);
                        AddData(details);
                    }
                    if (chocolatecakeb.isChecked()) {
                        Details details = new Details(uid, chocolatecake, cakeprice, 1);
                        AddData(details);
                    }
                    if (strawberrycakeb.isChecked()) {
                        Details details = new Details(uid, strawberrycake, cakeprice, 1);
                        AddData(details);
                    }
                    if (blueberrycakeb.isChecked()) {
                        Details details = new Details(uid, blueberrycake, cakeprice,1);
                        AddData(details);
                    }
                    if (toffeecakeb.isChecked()) {
                        Details details = new Details(uid, toffeecake, cakeprice,1);
                        AddData(details);
                    }
                    if (pbcakeb.isChecked()) {
                        Details details = new Details(uid, pbcake, cakeprice,1);
                        AddData(details);
                    }
                    if (chocolatechipb.isChecked()) {
                        Details details = new Details(uid, chocolatechip, cookieprice,1);
                        AddData(details);
                    }
                    if (oatmealraisinb.isChecked()) {
                        Details details = new Details(uid, oatmealraisin, cookieprice,1);
                        AddData(details);
                    }
                    if (pbcookieb.isChecked()) {
                        Details details = new Details(uid, pbcookie, cookieprice,1);
                        AddData(details);
                    }
                    if (macadamiab.isChecked()) {
                        Details details = new Details(uid, macadamia, cookieprice,1);
                        AddData(details);
                    }
                    if (redvelvetcupcakeb.isChecked()) {
                        Details details = new Details(uid, redvelvetcupcake, cupcakeprice,1);
                        AddData(details);
                    }
                    if (chocolatecupcakeb.isChecked()) {
                        Details details = new Details(uid, chocolatecupcake, cupcakeprice,1);
                        AddData(details);
                    }
                    if (vanillacupcakeb.isChecked()) {
                        Details details = new Details(uid, vanillacupcake, cupcakeprice,1);
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
