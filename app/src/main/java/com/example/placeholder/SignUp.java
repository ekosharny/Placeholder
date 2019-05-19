package com.example.placeholder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.placeholder.Database.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

    //creates variables for buttons/text-edit
    //users input name, email, password
    private EditText email, password, confirmP;
    private Button signup;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        //links variables to id in layout
        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);
        confirmP = findViewById(R.id.confirmP);
        signup = findViewById(R.id.signUpButton);




        //sign up button adds new users to database
        signup.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                //user inputs email, password which are used to create new customer object
                String addEmail = email.getText().toString();
                String addPassword = password.getText().toString();
                String cPassword = confirmP.getText().toString();

                if(addPassword.equals(cPassword)) {
                    createAccount(addEmail, addPassword);
                }
                else
                    Toast.makeText(SignUp.this, "Passwords don't match.",
                            Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void createAccount(String newemail, String newpassword){
        mAuth.createUserWithEmailAndPassword(newemail, newpassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            String uid= user.getUid();
                            String email = user.getEmail();
                            User newuser = new User(uid, email);
                            AddData(newuser);

                            startActivity(new Intent(SignUp.this, MainActivity.class));
                            finish();

                        } else {
                            Toast.makeText(SignUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    public void AddData(User user) {

        //creates new databasehelper and calls addHandler which adds the customer to the database
        DatabaseHelper dbHandler = new DatabaseHelper(this);
        dbHandler.addUser(user);
    }


}
