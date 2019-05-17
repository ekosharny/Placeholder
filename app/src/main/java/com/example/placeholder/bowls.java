package com.example.placeholder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class bowls extends AppCompatActivity {

    Button create, premade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bowls);

        create=findViewById(R.id.createButton);
        premade=findViewById(R.id.premadeButton);

        create.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(bowls.this, CreateBowls.class));
            }
        });
        premade.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(bowls.this, PremadeBowls.class));
            }
        });
    }

}
