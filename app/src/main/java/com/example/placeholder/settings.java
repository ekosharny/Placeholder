package com.example.placeholder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class settings extends AppCompatActivity {

    //creates variables for buttons/text-edit
    Button delete, save, logout;
    EditText changeUsername, changePassword, changePassword2;
    FirebaseUser user;
    TextView email,viewUsersDB, viewDetailsDB;
    String demail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        //links variable to id in layout
        delete = findViewById(R.id.deletebutton);
        save = findViewById(R.id.saveButton);
        changeUsername = findViewById(R.id.changeusername);
        changePassword = findViewById(R.id.changepassword);
        changePassword2 = findViewById(R.id.changepassword2);
        logout = findViewById(R.id.logout);
        email = findViewById(R.id.emailBox);
        viewUsersDB = findViewById(R.id.viewUsersDB);
        viewDetailsDB = findViewById(R.id.viewDetailsBox);

        user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {

            demail = user.getEmail();
            String uid = user.getUid();
        }

        email.setText("   " + demail);


        //delete button action
        delete.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                if(user!=null) {

                    user.delete();

                    String getEmail = user.getEmail();
                    boolean x = deleteAccount(getEmail);

                    startActivity(new Intent(settings.this, SignIn.class));
                }

                else
                    Toast.makeText(getApplicationContext(), "You are not logged in", Toast.LENGTH_SHORT).show();

            }
        });

        save.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user!=null) {
                    if(!(changeUsername.getText().toString().equals(""))){
                        user.updateEmail(changeUsername.getText().toString());
                    }

                    if(!changePassword.getText().toString().equals("")){
                        if(changePassword.getText().toString().equals(changePassword2.getText().toString()))
                            user.updatePassword(changePassword.getText().toString());
                        else
                            Toast.makeText(getApplicationContext(), "Passwords don't match", Toast.LENGTH_SHORT).show();
                    }
                }
                Toast.makeText(getApplicationContext(), "account Updated", Toast.LENGTH_SHORT).show();
                changeUsername.setText("");
                changePassword.setText("");
                changePassword2.setText("");

            }
        });

        //logout button redirects back to main page
        logout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(settings.this, SignIn.class));
                finish();
            }
        });


        viewUsersDB.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showUsers(view);
            }
        });


        viewDetailsDB.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showDetails(view);
            }
        });

    }


    public void showUsers(View view) {
        DatabaseHelper dbHandler = new DatabaseHelper(this);
        viewUsersDB.setText(dbHandler.loadUsers());
    }

    public void showDetails(View view){
        DatabaseHelper dbHandler = new DatabaseHelper(this);
        viewDetailsDB.setText(dbHandler.loadDetails());
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    public boolean deleteAccount(String email){
        //creates new DatabaseHelper and calls deleteHandler
        DatabaseHelper dhelper = new DatabaseHelper(this);
        boolean x = dhelper.deleteUser(email);
        return x;
    }

}