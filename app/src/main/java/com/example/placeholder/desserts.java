package com.example.placeholder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.placeholder.Database.Details;

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

        addToCart = findViewById(R.id.addDessertsButton);

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(redvelvetcakeb.isChecked()){
                    Details details = new Details(1, redvelvetcake, cakeprice);
                    AddData(details);
                }
                if(chocolatecakeb.isChecked()){
                    Details details = new Details(1, chocolatecake, cakeprice);
                    AddData(details);
                }
                if(strawberrycakeb.isChecked()){
                    Details details = new Details(1, strawberrycake, cakeprice);
                    AddData(details);
                }
                if(blueberrycakeb.isChecked()){
                    Details details = new Details(1, blueberrycake, cakeprice);
                    AddData(details);
                }
                if(toffeecakeb.isChecked()){
                    Details details = new Details(1, toffeecake, cakeprice);
                    AddData(details);
                }
                if(pbcakeb.isChecked()){
                    Details details = new Details(1, pbcake, cakeprice);
                    AddData(details);
                }
                if(chocolatechipb.isChecked()){
                    Details details = new Details(1, chocolatechip, cookieprice);
                    AddData(details);
                }
                if(oatmealraisinb.isChecked()){
                    Details details = new Details(1, oatmealraisin, cookieprice);
                    AddData(details);
                }
                if(pbcookieb.isChecked()){
                    Details details = new Details(1, pbcookie, cookieprice);
                    AddData(details);
                }
                if(macadamiab.isChecked()){
                    Details details = new Details(1, macadamia, cookieprice);
                    AddData(details);
                }
                if(redvelvetcupcakeb.isChecked()){
                    Details details = new Details(1, redvelvetcupcake, cupcakeprice);
                    AddData(details);
                }
                if(chocolatecupcakeb.isChecked()){
                    Details details = new Details(1, chocolatecupcake, cupcakeprice);
                    AddData(details);
                }
                if(vanillacupcakeb.isChecked()){
                    Details details = new Details(1, vanillacupcake, cupcakeprice);
                    AddData(details);
                }
            }
        });

    }

    public void AddData(Details details) {

        //creates new databasehelper and calls addHandler which adds the customer to the database
        DatabaseHelper dbHandler = new DatabaseHelper(this);
        dbHandler.addDetails(details);
    }
}
