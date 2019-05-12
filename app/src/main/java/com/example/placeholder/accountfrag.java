package com.example.placeholder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

//ACCOUNT TAB

public class accountfrag extends AppCompatActivity {

    private static final String Tag = "ACCOUNT";

    //create variables for the buttons in the layout
    private Button logout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);

        //link buttons to id of elements in layout
        logout = findViewById(R.id.logout);


        //logout button redirects back to main page
        logout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}