package com.example.placeholder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;

public class sides extends AppCompatActivity {

    Button addToCart;

    CheckBox potatochipsb, sourcreamchipsb, cheddarchipsb, bbqchipsb, popcornb;
    CheckBox whitebreadb, wholewheatb, wholegrainb, sourdoughb, pitab;
    CheckBox frenchonionb, clamchowderb, veggiesoupb, chickennoodleb;

    String potatochips, sourcreamchips, cheddarchips, bbqchips, popcorn;
    String whitebread, wholewheat, wholegrain, sourdough, pita;
    String frenchonion, clamchowder, veggiesoup, chickennoodle;

    final double chipsprice=2.00, breadprice=1.50, soupprice=4.50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sides);

        //SIDES BUTTONS
        potatochipsb = findViewById(R.id.potatochipsButton);
        sourcreamchipsb = findViewById(R.id.sourcreamButton);
        cheddarchipsb  = findViewById(R.id.cheddarButton);
        bbqchipsb  = findViewById(R.id.bbqButton);
        popcornb = findViewById(R.id.popcornButton);
        whitebreadb  = findViewById(R.id.whitebreadButton);
        wholewheatb = findViewById(R.id.wholewheatButton);
        wholegrainb = findViewById(R.id.wholegrainButton);
        sourdoughb = findViewById(R.id.sourdoughButton);
        pitab = findViewById(R.id.pitaButton);
        frenchonionb = findViewById(R.id.frenchonionButton);
        clamchowderb = findViewById(R.id.clamchowderButton);
        veggiesoupb = findViewById(R.id.veggieButton);
        chickennoodleb = findViewById(R.id.chickennoodleButton);

        //SIDE STRINGS
        potatochips = findViewById(R.id.potatochipsButton).toString();
        sourcreamchips = findViewById(R.id.sourcreamButton).toString();
        cheddarchips  = findViewById(R.id.cheddarButton).toString();
        bbqchips  = findViewById(R.id.bbqButton).toString();
        popcorn = findViewById(R.id.popcornButton).toString();
        whitebread  = findViewById(R.id.whitebreadButton).toString();
        wholewheat = findViewById(R.id.wholewheatButton).toString();
        wholegrain = findViewById(R.id.wholegrainButton).toString();
        sourdough = findViewById(R.id.sourdoughButton).toString();
        pita = findViewById(R.id.pitaButton).toString();
        frenchonion = findViewById(R.id.frenchonionButton).toString();
        clamchowder = findViewById(R.id.clamchowderButton).toString();
        veggiesoup = findViewById(R.id.veggieButton).toString();
        chickennoodle = findViewById(R.id.chickennoodleButton).toString();

        addToCart = findViewById(R.id.addItemsButton);


    }
}
