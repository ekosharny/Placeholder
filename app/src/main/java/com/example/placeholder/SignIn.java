package com.example.placeholder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignIn extends AppCompatActivity {

    //creates variables for buttons and text-edit in the layout
    Button login, click;
    EditText email, password;
    DatabaseHelper dhelper;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        dhelper = new DatabaseHelper(this);

        mAuth = FirebaseAuth.getInstance();

        //links the buttons/text-edit to the id's in the layout
        login = findViewById(R.id.button);
        email = findViewById(R.id.email);
        password =  findViewById(R.id.password);
        click = findViewById(R.id.click);

        //gives the login button an action
        login.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                String addEmail = email.getText().toString();
                String addPassword = password.getText().toString();
                signIn(addEmail, addPassword);


            }
        });

        //click button redirects users to "sign up with new account" page
        click.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn.this, SignUp.class));
            }
        });


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public void signIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(SignIn.this, MainActivity.class));
                            finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(SignIn.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    //method used to find the user record based on the username input
    public Customer findUser(View v){

        //creates a new customer and uses findHandler method in DatabaseHelper to find user
        Customer customer =  dhelper.findHandler(email.getText().toString());
        //returns the customer found in database if not null
        if(customer!=null){
            return customer;
        }
        else
            return null;
    }
}
