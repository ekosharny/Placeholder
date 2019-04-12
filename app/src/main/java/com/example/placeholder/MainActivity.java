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
                Customer customer = findUser(v);
                if(username.getText().toString().equals(customer.getEmail()) && password.getText().toString().equals(customer.getPassword())) {
                    startActivity(new Intent(MainActivity.this, TabFragments.class));
                }

                else if(username.getText().toString().equals(customer.getEmail()) && password.getText().toString()!=(customer.getPassword())){
                    Toast.makeText(getApplicationContext(), "Wrong password",
                            Toast.LENGTH_SHORT).show();
                }

                else {
                    Toast.makeText(getApplicationContext(), "Account does not exist",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        click.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUp.class));
            }
        });


    }

    public Customer findUser(View v){
        DatabaseHelper dhelper = new DatabaseHelper(this);
        Customer customer =  dhelper.findHandler(username.getText().toString());
        return customer;
    }
}
