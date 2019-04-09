package com.example.placeholder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login, click;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.button);
        username = findViewById(R.id.username);
        password =  findViewById(R.id.password);
        click = findViewById(R.id.click);

        login.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                if(username.getText().toString().equals("admin") &&
                password.getText().toString().equals("avocados")) {
                    //Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
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
