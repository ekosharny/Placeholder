package com.example.placeholder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.placeholder.Database.Details;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                if (user != null) {
                    String uid = user.getUid();
                    Details details = new Details(uid, cali, caliprice,1);
                    AddData(details);
                }
            }
        });

        tritrib.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                if (user != null) {
                    String uid = user.getUid();
                    Details details = new Details(uid, tritri, tritriprice,1);
                    AddData(details);
                }
            }
        });
        macfergusb.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                if (user != null) {
                    String uid = user.getUid();
                    Details details = new Details(uid, macfergus, macfergusprice,1);
                    AddData(details);
                }
            }
        });
        hawaiianb.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                if (user != null) {
                    String uid = user.getUid();
                    Details details = new Details(uid, hawaiian, hawaiianprice, 1);
                    AddData(details);
                }
            }
        });
        vegeterianb.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                if (user != null) {
                    String uid = user.getUid();
                    Details details = new Details(uid, vegeterian, vegetarianprice,1);
                    AddData(details);
                }
            }
        });
        farmerb.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                if (user != null) {
                    String uid = user.getUid();
                    Details details = new Details(uid, farmer, farmerprice,1);
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
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
