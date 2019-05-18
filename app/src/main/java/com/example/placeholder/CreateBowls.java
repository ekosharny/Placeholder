package com.example.placeholder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;

public class CreateBowls extends AppCompatActivity {

    CheckBox whiteRiceb, brownRiceb, mashedPotatob, quinoab, mixedGreensb;
    CheckBox chickenb, spicyTunab, shrimpb, tofub, beefb, salmonb;
    CheckBox onionsb, cabbageb, cherryTomatoesb, cucumberb, dicedTomatoesb, jalapenosb, carrotsb, peppersb;
    CheckBox avocadob, pineappleb, edamameb, sesameSeedsb, masagob;
    CheckBox soyb, duckb, ranchb, spicyMayob, srirachab;

    String whiteRice, brownRice, mashedPotato, quinoa, mixedGreens;
    String chicken, spicyTuna, shrimp, tofu, beef, salmon;
    String onions, cabbage, cherryTomatoes, cucumber, dicedTomatoes, jalapenos, carrots, peppers;
    String avocado, pineapple, edamame, sesameSeeds, masago;
    String soy, duck, ranch, spicyMayo, sriracha;

    final double bowlprice=12.00;


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
    }


}
