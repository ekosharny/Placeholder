package com.example.placeholder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class CreateBowls extends AppCompatActivity {

    String whiteRice, brownRice, mashedPotato, quinoa, mixedGreens;
    String chicken, spicyTuna, shrimp, tofu, beef, salmon;
    String onions, cabbage, cherryTomatoes, cucumber, dicedTomatoes, jalapenos, carrots, peppers;
    String avocado, pineapple, edamame, sesameSeeds, masago;
    String soy, duck, ranch, spicyMayo, sriracha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bowls);

        //BASE
        whiteRice = findViewById(R.id.whiteRiceBox).toString();
        brownRice = findViewById(R.id.brownRiceBox).toString();
        mashedPotato = findViewById(R.id.mashedPotatoBox).toString();
        quinoa = findViewById(R.id.quinoaBox).toString();
        mixedGreens = findViewById(R.id.mixedGreensBox).toString();

        //PROTEIN
        chicken = findViewById(R.id.chickenBox).toString();
        spicyTuna = (findViewById(R.id.spicyTunaBox)).toString();
        shrimp=(findViewById(R.id.shrimpBox)).toString();
        tofu=(findViewById(R.id.tofuBox)).toString();
        beef=(findViewById(R.id.beefBox)).toString();
        salmon=(findViewById(R.id.salmonBox)).toString();

        //VEGGIES
        onions =(findViewById(R.id.onionsBox)).toString();
        cabbage=(findViewById(R.id.cabbageBox)).toString();
        cherryTomatoes=(findViewById(R.id.cherryTomatoBox)).toString();
        cucumber=(findViewById(R.id.cucumberBox)).toString();
        dicedTomatoes=(findViewById(R.id.dicedTomatoBox)).toString();
        jalapenos=(findViewById(R.id.jalapenosBox)).toString();
        carrots =(findViewById(R.id.carrotsBox)).toString();
        peppers=(findViewById(R.id.peppersBox)).toString();

        //TOPPINGS
        avocado=(findViewById(R.id.avocadoBox)).toString();
        pineapple=(findViewById(R.id.pineappleBox)).toString();
        edamame=(findViewById(R.id.edamameBox)).toString();
        sesameSeeds=(findViewById(R.id.sesameBox)).toString();
        masago=(findViewById(R.id.masagoBox)).toString();

        //DRESSING
        soy=(findViewById(R.id.soyBox)).toString();
        duck=(findViewById(R.id.duckBox)).toString();
        ranch=(findViewById(R.id.ranchBox)).toString();
        spicyMayo=(findViewById(R.id.spicyMayoBox)).toString();
        sriracha=(findViewById(R.id.srirachaBox)).toString();
    }
}
