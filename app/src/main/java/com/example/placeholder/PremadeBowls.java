package com.example.placeholder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.placeholder.Database.Details;

public class PremadeBowls extends AppCompatActivity {

    Button calib, tritrib, macfergusb, hawaiianb, vegeterianb, farmerb;
    String cali, tritri, macfergus, hawaiian, vegeterian, farmer;

    final double caliprice=11.00, tritriprice=11.00, macfergusprice=11.50, hawaiianprice=11.00, vegetarianprice=10.00, farmerprice=11.00;


    Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premade_bowls);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        //BUTTONS
        calib=findViewById(R.id.addCali);
        tritrib=findViewById(R.id.addTriTri);
        macfergusb=findViewById(R.id.addMacFergus);
        hawaiianb=findViewById(R.id.addHawaiian);
        vegeterianb=findViewById(R.id.addVegetarian);
        farmerb=findViewById(R.id.addFarmer);

        //STRINGS
        cali="Cali Bowl";
        tritri="TriTri Bowl";
        macfergus="MacFergus Bowl";
        hawaiian="Hawaiian Bowl";
        vegeterian = "Vegeterian Bowl";
        farmer= "Farmer Bowl";

        create= findViewById(R.id.createOwnBowlButton);

        create.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(PremadeBowls.this, CreateBowls.class));
            }
        });

        calib.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Details details = new Details(1, cali, caliprice);
                AddData(details);
            }
        });

        tritrib.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Details details = new Details(1, tritri, tritriprice);
                AddData(details);
            }
        });
        macfergusb.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Details details = new Details(1, macfergus, macfergusprice);
                AddData(details);
            }
        });
        hawaiianb.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Details details = new Details(1, hawaiian, hawaiianprice);
                AddData(details);
            }
        });
        vegeterianb.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Details details = new Details(1, vegeterian, vegetarianprice);
                AddData(details);
            }
        });
        farmerb.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Details details = new Details(1, farmer, farmerprice);
                AddData(details);
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
