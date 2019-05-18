package com.example.placeholder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//ACCOUNT TAB

public class accountfrag extends AppCompatActivity {

    private static final String Tag = "ACCOUNT";

    //create variables for the buttons in the layout
    private Button logout;
    TextView email,viewUsersDB;
    String demail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);

        //link buttons to id of elements in layout
        logout = findViewById(R.id.logout);
        email = findViewById(R.id.emailBox);
        viewUsersDB = findViewById(R.id.viewUsersBox);

        viewUsersDB.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showUsers(view);
            }
        });

        //logout button redirects back to main page
        logout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(accountfrag.this, SignIn.class));
                finish();
            }
        });


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {

            demail = user.getEmail();

            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user.getUid();
        }

        email.setText(demail);

    }

    public void showUsers(View view) {
        DatabaseHelper dbHandler = new DatabaseHelper(this);
        viewUsersDB.setText(dbHandler.loadUsers());
    }

}