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

    //creates variables for buttons and text-edit in the layout
    Button login, click;
    EditText username, password;
    DatabaseHelper dhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dhelper = new DatabaseHelper(this);

        //links the buttons/text-edit to the id's in the layout
        login = findViewById(R.id.button);
        username = findViewById(R.id.username);
        password =  findViewById(R.id.password);
        click = findViewById(R.id.click);

        //gives the login button an action
        login.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                //creates a new customer object and calls findUser which uses username to find the record
                Customer customer = findUser(v);

                //if username/email exists in the database and the password matches the input, redirects to next page
                //if username/email exists in the database but the password doesn't match the input, displays message
                if(customer !=null) {
                    if (username.getText().toString().equals(customer.getEmail()) && password.getText().toString().equals(customer.getPassword())) {
                        startActivity(new Intent(MainActivity.this, TabFragments.class));
                    }
                    else if (username.getText().toString().equals(customer.getEmail()) && password.getText().toString() != (customer.getPassword())) {
                        Toast.makeText(getApplicationContext(), "Wrong password",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                //display message if username/email doesn't exist in the database
                else
                    Toast.makeText(getApplicationContext(), "Account doesn't exist",
                            Toast.LENGTH_SHORT).show();

            }
        });

        //click button redirects users to "sign up with new account" page
        click.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUp.class));
            }
        });


    }

    //method used to find the user record based on the username input
    public Customer findUser(View v){

        //creates a new customer and uses findHandler method in DatabaseHelper to find user
        Customer customer =  dhelper.findHandler(username.getText().toString());
        //returns the customer found in database if not null
        if(customer!=null){
            return customer;
        }
        else
            return null;
    }
}
