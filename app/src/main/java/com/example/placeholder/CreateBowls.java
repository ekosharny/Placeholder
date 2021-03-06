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

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
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
        whiteRice = "White Rice";
        brownRice = "Brown Rice";
        mashedPotato = "Mashed Potato";
        quinoa = "Quinoa";
        mixedGreens = "Mixed Greens";

        //PROTEIN STRINGS
        chicken = "Chicken";
        spicyTuna = "Spicy Tuna";
        shrimp="Shrimp";
        tofu="Tofu";
        beef="Beef";
        salmon="Salmon";

        //VEGGIES STRINGS
        onions ="Onions";
        cabbage="Cabbage";
        cherryTomatoes="Cherry Tomatoes";
        cucumber="Cucumber";
        dicedTomatoes="Diced Tomatoes";
        jalapenos="Jalapenos";
        carrots ="Carrots";
        peppers="Peppers";

        //TOPPINGS STRINGS
        avocado="Avocado";
        pineapple="Pineapple";
        edamame="Edamame";
        sesameSeeds="Sesame Seeds";
        masago="Masago";

        //DRESSING STRINGS
        soy="Soy Sauce";
        duck="Duck Sauce";
        ranch="Ranch";
        spicyMayo="Spicy Mayo";
        sriracha="Sriracha";


        add=findViewById(R.id.addCreateBowl);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String custombowl="Custom Bowl: ";

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

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String e;

                if (user != null) {
                    e = user.getEmail();
                    Details details = new Details(1, custombowl, bowlprice, e);
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
