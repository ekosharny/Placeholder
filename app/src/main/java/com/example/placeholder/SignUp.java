package com.example.placeholder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    //creates variables for buttons/text-edit
    //users input name, email, password
    DatabaseHelper mDatabaseHelper;
    private EditText name, email, password;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //links variables to id in layout
        name = findViewById(R.id.nameInput);
        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);
        signup = findViewById(R.id.signUpButton);

        mDatabaseHelper = new DatabaseHelper(this);

        //sign up button adds new users to database
        signup.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                //user inputs name, email, password which are used to create new customer object
                String addName = name.getText().toString();
                String addEmail = email.getText().toString();
                String addPassword = password.getText().toString();

                Customer customer = new Customer(addName, addEmail, addPassword);

                //calls addData to add the new customer to database
                AddData(customer);

            }
        });

    }

    //method adds new customer to database
    public void AddData(Customer customer) {

        //creates new databasehelper and calls addHandler which adds the customer to the database
        DatabaseHelper dbHandler = new DatabaseHelper(this);
        dbHandler.addHandler(customer);

        //set text to empty string after customer is added
        name.setText("");
        email.setText("");
        password.setText("");
    }


}
