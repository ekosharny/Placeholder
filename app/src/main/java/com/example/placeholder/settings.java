package com.example.placeholder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class settings extends AppCompatActivity {

    Button delete;
    EditText confirmUsername, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        delete = findViewById(R.id.deletebutton);
        confirmUsername = findViewById(R.id.conUser);
        confirmPassword = findViewById(R.id.conPass);

        delete.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                Customer customer = findUser(v);
                if(confirmUsername.getText().toString().equals(customer.getEmail()) && confirmPassword.getText().toString().equals(customer.getPassword())) {
                    boolean x = deleteAccount(customer);
                    if(x==true)
                        Toast.makeText(getApplicationContext(), "Account deleted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(), "Couldn't delete account", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(settings.this, MainActivity.class));
                }

                else
                    Toast.makeText(getApplicationContext(), "Wrong username or password", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public boolean deleteAccount(Customer customer){
        DatabaseHelper dhelper = new DatabaseHelper(this);
        boolean x = dhelper.deleteHandler(customer.getName());
        return x;
    }

    public Customer findUser(View v){
        DatabaseHelper dhelper = new DatabaseHelper(this);
        Customer customer =  dhelper.findHandler(confirmUsername.getText().toString());
        return customer;
    }

}
