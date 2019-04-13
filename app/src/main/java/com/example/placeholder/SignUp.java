package com.example.placeholder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {


    DatabaseHelper mDatabaseHelper;
    private EditText name, email, password;
    private Button signup;
    //private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.nameInput);
        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);
        signup = findViewById(R.id.signUpButton);
        //output = findViewById(R.id.outputview);

        mDatabaseHelper = new DatabaseHelper(this);

        signup.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String addName = name.getText().toString();
                String addEmail = email.getText().toString();
                String addPassword = password.getText().toString();

                Customer customer = new Customer(addName, addEmail, addPassword);
                AddData(customer);

                //showCustomers(v);
            }
        });

    }

    public void AddData(Customer customer) {

        DatabaseHelper dbHandler = new DatabaseHelper(this);
        dbHandler.addHandler(customer);
        name.setText("");
        email.setText("");
        password.setText("");
    }


    /*
    public void showCustomers(View view) {
        DatabaseHelper dbHandler = new DatabaseHelper(this);
        output.setText(dbHandler.loadHandler());
        name.setText("");
        email.setText("");
        password.setText("");
    }
*/

}
