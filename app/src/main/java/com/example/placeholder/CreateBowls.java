package com.example.placeholder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.placeholder.Database.Details;

public class CreateBowls extends AppCompatActivity {

    RadioButton whiteRiceb, brownRiceb, mashedPotatob, quinoab, mixedGreensb;
    RadioButton chickenb, spicyTunab, shrimpb, tofub, beefb, salmonb;
    CheckBox onionsb, cabbageb, cherryTomatoesb, cucumberb, dicedTomatoesb, jalapenosb, carrotsb, peppersb;
    CheckBox avocadob, pineappleb, edamameb, sesameSeedsb, masagob;
    CheckBox soyb, duckb, ranchb, spicyMayob, srirachab;

    String whiteRice, brownRice, mashedPotato, quinoa, mixedGreens;
    String chicken, spicyTuna, shrimp, tofu, beef, salmon;
    String onions, cabbage, cherryTomatoes, cucumber, dicedTomatoes, jalapenos, carrots, peppers;
    String avocado, pineapple, edamame, sesameSeeds, masago;
    String soy, duck, ranch, spicyMayo, sriracha;

    final double bowlprice=12.00;

    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bowls);

        //BASE BUTTONS
        whiteRiceb = findViewById(R.id.whiteRiceBox);
        brownRiceb = findViewById(R.id.brownRiceBox);
        mashedPotatob = findViewById(R.id.mashedPotatoBox);
        quinoab = findViewById(R.id.quinoaBox);
        mixedGreensb = findViewById(R.id.mixedGreensBox);


        //PROTEIN BUTTONS
        chickenb = findViewById(R.id.chickenBox);
        spicyTunab = findViewById(R.id.spicyTunaBox);
        shrimpb=findViewById(R.id.shrimpBox);
        tofub=findViewById(R.id.tofuBox);
        beefb=findViewById(R.id.beefBox);
        salmonb=findViewById(R.id.salmonBox);

        //VEGGIES BUTTONS
        onionsb =findViewById(R.id.onionsBox);
        cabbageb=findViewById(R.id.cabbageBox);
        cherryTomatoesb=findViewById(R.id.cherryTomatoBox);
        cucumberb=findViewById(R.id.cucumberBox);
        dicedTomatoesb=findViewById(R.id.dicedTomatoBox);
        jalapenosb=findViewById(R.id.jalapenosBox);
        carrotsb =findViewById(R.id.carrotsBox);
        peppersb=findViewById(R.id.peppersBox);

        //TOPPINGS BUTTONS
        avocadob=findViewById(R.id.avocadoBox);
        pineappleb=findViewById(R.id.pineappleBox);
        edamameb=findViewById(R.id.edamameBox);
        sesameSeedsb=findViewById(R.id.sesameBox);
        masagob=findViewById(R.id.masagoBox);

        //DRESSING BUTTONS
        soyb=findViewById(R.id.soyBox);
        duckb=findViewById(R.id.duckBox);
        ranchb=findViewById(R.id.ranchBox);
        spicyMayob=findViewById(R.id.spicyMayoBox);
        srirachab=findViewById(R.id.srirachaBox);

        //BASE STRINGS
        whiteRice = findViewById(R.id.whiteRiceBox).toString();
        brownRice = findViewById(R.id.brownRiceBox).toString();
        mashedPotato = findViewById(R.id.mashedPotatoBox).toString();
        quinoa = findViewById(R.id.quinoaBox).toString();
        mixedGreens = findViewById(R.id.mixedGreensBox).toString();

        //PROTEIN STRINGS
        chicken = findViewById(R.id.chickenBox).toString();
        spicyTuna = (findViewById(R.id.spicyTunaBox)).toString();
        shrimp=(findViewById(R.id.shrimpBox)).toString();
        tofu=(findViewById(R.id.tofuBox)).toString();
        beef=(findViewById(R.id.beefBox)).toString();
        salmon=(findViewById(R.id.salmonBox)).toString();

        //VEGGIES STRINGS
        onions =(findViewById(R.id.onionsBox)).toString();
        cabbage=(findViewById(R.id.cabbageBox)).toString();
        cherryTomatoes=(findViewById(R.id.cherryTomatoBox)).toString();
        cucumber=(findViewById(R.id.cucumberBox)).toString();
        dicedTomatoes=(findViewById(R.id.dicedTomatoBox)).toString();
        jalapenos=(findViewById(R.id.jalapenosBox)).toString();
        carrots =(findViewById(R.id.carrotsBox)).toString();
        peppers=(findViewById(R.id.peppersBox)).toString();

        //TOPPINGS STRINGS
        avocado=(findViewById(R.id.avocadoBox)).toString();
        pineapple=(findViewById(R.id.pineappleBox)).toString();
        edamame=(findViewById(R.id.edamameBox)).toString();
        sesameSeeds=(findViewById(R.id.sesameBox)).toString();
        masago=(findViewById(R.id.masagoBox)).toString();

        //DRESSING STRINGS
        soy=(findViewById(R.id.soyBox)).toString();
        duck=(findViewById(R.id.duckBox)).toString();
        ranch=(findViewById(R.id.ranchBox)).toString();
        spicyMayo=(findViewById(R.id.spicyMayoBox)).toString();
        sriracha=(findViewById(R.id.srirachaBox)).toString();


        add=findViewById(R.id.addCreateBowl);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String custombowl="";

                if(whiteRiceb.isChecked() || brownRiceb.isChecked() || mashedPotatob.isChecked() || quinoab.isChecked() || mixedGreensb.isChecked()) {
                    if (whiteRiceb.isChecked()) {
                        custombowl += (whiteRice + ", ");
                    } else if (brownRiceb.isChecked()) {
                        custombowl += (brownRice + ", ");
                    } else if (mashedPotatob.isChecked()) {
                        custombowl += (mashedPotato + ", ");
                    } else if (quinoab.isChecked()) {
                        custombowl += (quinoa + ", ");
                    } else if (mixedGreensb.isChecked()) {
                        custombowl += (mixedGreens + ", ");
                    }
                }
                else
                    Toast.makeText(CreateBowls.this, "Please add a base", Toast.LENGTH_SHORT).show();

                if(chickenb.isChecked() || spicyTunab.isChecked() || shrimpb.isChecked() || tofub.isChecked() || beefb.isChecked() || salmonb.isChecked()) {
                    if (chickenb.isChecked()) {
                        custombowl += (chicken + ", ");
                    } else if (spicyTunab.isChecked()) {
                        custombowl += (spicyTuna + ", ");
                    } else if (shrimpb.isChecked()) {
                        custombowl += (shrimp + ", ");
                    } else if (tofub.isChecked()) {
                        custombowl += (tofu + ", ");
                    } else if (beefb.isChecked()) {
                        custombowl += (beef + ", ");
                    } else if (salmonb.isChecked()) {
                        custombowl += (salmon + ", ");
                    }
                }
                else
                    Toast.makeText(CreateBowls.this, "Please add a protein", Toast.LENGTH_SHORT).show();


                //VEGGIES
                if(onionsb.isChecked()){
                    custombowl += (onions = ", ");
                }
                if(cabbageb.isChecked()){
                    custombowl += (cabbage = ", ");
                }
                if(cherryTomatoesb.isChecked()){
                    custombowl += (cherryTomatoes = ", ");
                }
                if(cucumberb.isChecked()){
                    custombowl += (cucumber = ", ");
                }
                if(dicedTomatoesb.isChecked()){
                    custombowl += (dicedTomatoes = ", ");
                }
                if(jalapenosb.isChecked()) {
                    custombowl += (jalapenos = ", ");
                }
                if(carrotsb.isChecked()){
                    custombowl += (carrots = ", ");
                }
                if(peppersb.isChecked()){
                    custombowl += (peppers = ", ");
                }


                //TOPPINGS
                if(avocadob.isChecked()){
                    custombowl += (avocado = ", ");
                }
                if(pineappleb.isChecked()){
                    custombowl += (pineapple = ", ");
                }
                if(edamameb.isChecked()){
                    custombowl += (edamame = ", ");
                }
                if(sesameSeedsb.isChecked()){
                    custombowl += (sesameSeeds = ", ");
                }
                if(masagob.isChecked()){
                    custombowl += (masago = ", ");
                }


                //SAUCE
                if(soyb.isChecked()){
                    custombowl += (soy = ".");
                }
                if(duckb.isChecked()){
                    custombowl += (duck = ".");
                }
                if(ranchb.isChecked()){
                    custombowl += (ranch = ".");
                }
                if(spicyMayob.isChecked()){
                    custombowl += (spicyMayo = ".");
                }
                if(srirachab.isChecked()){
                    custombowl += (sriracha = ".");
                }

                Details details = new Details(1, custombowl, bowlprice);
                AddData(details);

            }
        });
    }

    public void AddData(Details details) {

        //creates new databasehelper and calls addHandler which adds the customer to the database
        DatabaseHelper dbHandler = new DatabaseHelper(this);
        dbHandler.addDetails(details);
    }

}
