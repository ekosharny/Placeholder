package com.example.placeholder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

import android.app.Activity;
import android.graphics.Color;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login, click;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.button);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        click = (Button) findViewById(R.id.click);

        login.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                if(username.getText().toString().equals("username") &&
                password.getText().toString().equals("avocados")) {
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, TabFragments.class));
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong username or password",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        click.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TabFragments.class));
            }
        });


    }
}
