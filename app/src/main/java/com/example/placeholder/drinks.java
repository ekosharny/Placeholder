package com.example.placeholder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.placeholder.Database.Details;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class drinks extends AppCompatActivity {

     Button addToCart;

     CheckBox cocacolab, pepsib, mountaindewb, spriteb, fantab;
     CheckBox applejb, cranberryjb, orangejb, lemonadeb, pineapplejb;
     RadioButton greekyogurtb, wholemilkb, almondmilkb, soymilkb, coconutmilkb;
     CheckBox appleb, bananab, orangeb, strawberriesb, blueberriesb;

     String cocacola, pepsi, mountaindew, sprite, fanta;
     String applej, cranberryj, orangej, lemonade, pineapplej;
     String greekyogurt, wholemilk, almondmilk, soymilk, coconutmilk;
     String apple, banana, orange, strawberries, blueberries;

     final double sodaprice=2.00, juiceprice=3.00, smoothieprice=5.50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
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

        cocacola = "Coca Cola";
        pepsi = "Pepsi";
        mountaindew  = "Mountain Dew";
        sprite  = "Sprite";
        fanta = "Fanta";
        applej  = "Apple Juice";
        cranberryj = "Cranberry Juice";
        orangej = "Orange Juice";
        lemonade = "Lemonade";
        pineapplej = "Pineapple Juice";
        greekyogurt = "Greek Yogurt";
        wholemilk = "Whole Milk";
        almondmilk = "Almond Milk";
        soymilk = "Soy Milk";
        coconutmilk = "Coconut Milk";
        apple = "Apple";
        banana = "Banana";
        orange = "Orange";
        strawberries = "Strawberries";
        blueberries = "Blueberries";

        addToCart = findViewById(R.id.addDrinksButton);

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                if (user != null) {
                    String uid = user.getUid();
                    if (cocacolab.isChecked()) {
                        Details details = new Details(uid, cocacola, sodaprice, 1);
                        AddData(details);
                    }
                    if (pepsib.isChecked()) {
                        Details details = new Details(uid, pepsi, sodaprice,1);
                        AddData(details);
                    }
                    if (mountaindewb.isChecked()) {
                        Details details = new Details(uid, mountaindew, sodaprice, 1);
                        AddData(details);
                    }
                    if (spriteb.isChecked()) {
                        Details details = new Details(uid, sprite, sodaprice, 1);
                        AddData(details);
                    }
                    if (fantab.isChecked()) {
                        Details details = new Details(uid, fanta, sodaprice,1);
                        AddData(details);
                    }
                    if (applejb.isChecked()) {
                        Details details = new Details(uid, applej, juiceprice,1);
                        AddData(details);
                    }
                    if (cranberryjb.isChecked()) {
                        Details details = new Details(uid, cranberryj, juiceprice,1);
                        AddData(details);
                    }
                    if (orangejb.isChecked()) {
                        Details details = new Details(uid, orangej, juiceprice,1);
                        AddData(details);
                    }
                    if (lemonadeb.isChecked()) {
                        Details details = new Details(uid, lemonade, juiceprice,1);
                        AddData(details);
                    }
                    if (pineapplejb.isChecked()) {
                        Details details = new Details(uid, pineapplej, juiceprice,1);
                        AddData(details);
                    }

                    String smoothie = "Smoothie: ";

                    if (greekyogurtb.isChecked() || wholemilkb.isChecked() || almondmilkb.isChecked() || soymilkb.isChecked() || coconutmilkb.isChecked()) {
                        if (greekyogurtb.isChecked()) {
                            smoothie += (greekyogurt + ", ");
                        } else if (wholemilkb.isChecked()) {
                            smoothie += (wholemilk + ", ");
                        } else if (almondmilkb.isChecked()) {
                            smoothie += (almondmilk + ", ");
                        } else if (soymilkb.isChecked()) {
                            smoothie += (soymilk + ", ");
                        } else if (coconutmilkb.isChecked()) {
                            smoothie += (coconutmilk + ", ");
                        }

                        if (appleb.isChecked())
                            smoothie += (apple + ", ");
                        if (bananab.isChecked())
                            smoothie += (banana + ", ");
                        if (orangeb.isChecked())
                            smoothie += (orange + ", ");
                        if (strawberriesb.isChecked())
                            smoothie += (strawberries + ", ");
                        if (blueberriesb.isChecked())
                            smoothie += (blueberries + ", ");

                        Details details = new Details(uid, smoothie, smoothieprice,1);
                        AddData(details);
                    } else {
                        if (appleb.isChecked() || bananab.isChecked() || orangeb.isChecked() || strawberriesb.isChecked() || blueberriesb.isChecked()) {
                            Toast.makeText(drinks.this, "Please add a base", Toast.LENGTH_SHORT).show();
                        }
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
