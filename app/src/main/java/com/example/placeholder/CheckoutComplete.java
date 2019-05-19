package com.example.placeholder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckoutComplete extends AppCompatActivity {

    Button returnToMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_complete);

        returnToMenu = findViewById(R.id.returnToMenuButton);

        returnToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckoutComplete.this, MainActivity.class));
                finish();
            }
        });
    }
}
