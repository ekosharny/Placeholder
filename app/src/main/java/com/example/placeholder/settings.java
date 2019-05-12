package com.example.placeholder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class settings extends AppCompatActivity {

    //creates variables for buttons/text-edit
    Button delete, save;
    EditText changeUsername, changePassword, changePassword2;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //links variable to id in layout
        delete = findViewById(R.id.deletebutton);
        save = findViewById(R.id.saveButton);
        changeUsername = findViewById(R.id.changeusername);
        changePassword = findViewById(R.id.changepassword);
        changePassword2 = findViewById(R.id.changepassword2);

        user = FirebaseAuth.getInstance().getCurrentUser();

        //delete button action
        delete.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                if(user!=null) {

                    user.delete();

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
                Toast.makeText(getApplicationContext(), "Account Updated", Toast.LENGTH_SHORT).show();
                changeUsername.setText("");
                changePassword.setText("");
                changePassword2.setText("");

            }
        });

    }

}
