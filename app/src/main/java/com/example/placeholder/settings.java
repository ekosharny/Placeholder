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

    //creates variables for buttons/text-edit
    Button delete, change, update;
    EditText confirmUsername, confirmPassword, changeName, changeUsername, changePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //links variable to id in layout
        delete = findViewById(R.id.deletebutton);
        change = findViewById(R.id.changeButton);
        update = findViewById(R.id.updateButton);
        confirmUsername = findViewById(R.id.conUser);
        confirmPassword = findViewById(R.id.conPass);
        changeName = findViewById(R.id.changename);
        changeUsername = findViewById(R.id.changeusername);
        changePassword = findViewById(R.id.changepassword);


        //delete button action
        delete.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                //creates a new customer object that finds user
                Customer customer = findUser(v);
                //if username exists in the database and it matches the password on the record then call deleteAccount method and redirct to main login page
                if(confirmUsername.getText().toString().equals(customer.getEmail()) && confirmPassword.getText().toString().equals(customer.getPassword())) {
                    boolean x = deleteAccount(customer);
                    if(x==true)
                        Toast.makeText(getApplicationContext(), "Account deleted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(), "Couldn't delete account", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(settings.this, SignIn.class));
                }

                //display message if username doesn't exist in database or password is wrong
                else
                    Toast.makeText(getApplicationContext(), "Wrong username or password", Toast.LENGTH_SHORT).show();

            }
        });

        change.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //creates a new customer object that finds user
                Customer customer = findUser(v);
                if(customer!=null) {
                    //if username exists in the database and it matches the password on the record then call deleteAccount method and redirct to main login page
                    if (confirmUsername.getText().toString().equals(customer.getEmail()) && confirmPassword.getText().toString().equals(customer.getPassword())) {
                        changeName.setVisibility(View.VISIBLE);
                        changeUsername.setVisibility(View.VISIBLE);
                        changePassword.setVisibility(View.VISIBLE);
                        update.setVisibility(View.VISIBLE);

                    }

                    //display message if username doesn't exist in database or password is wrong
                    else
                        Toast.makeText(getApplicationContext(), "Wrong username or password", Toast.LENGTH_SHORT).show();

                }
                else
                    Toast.makeText(getApplicationContext(), "Account doesn't exist",
                            Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Customer customer = findUser(v);
                boolean x = updateCustomer(customer);
                if(x==true)
                    Toast.makeText(getApplicationContext(), "Account Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Couldn't Update Account", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //delete method deletes a customer from the database
    public boolean deleteAccount(Customer customer){
        //creates new DatabaseHelper and calls deleteHandler
        DatabaseHelper dhelper = new DatabaseHelper(this);
        boolean x = dhelper.deleteHandler(customer.getName());
        return x;
    }

    //uses username input to find the user in the database
    public Customer findUser(View v){
        //creates a new DatabaseHelper object
        DatabaseHelper dhelper = new DatabaseHelper(this);

        //creates a new customer and uses findHandler method in DatabaseHelper to find user
        Customer customer =  dhelper.findHandler(confirmUsername.getText().toString());
        //returns the customer found in database if not null
        if(customer!=null){
            return customer;
        }
        else
            return null;
    }

    //this method updates whatever the uses changes
    //the if statement tests for different possibilities of input
    public boolean updateCustomer(Customer customer){
        DatabaseHelper dhelper = new DatabaseHelper(this);

        boolean x=false;

        if(!(changeName.getText().toString().equals("")) && !(changeUsername.getText().toString().equals("")) && !(changePassword.getText().toString().equals(""))){
            x = dhelper.updateHandler(changeName.getText().toString(), changeUsername.getText().toString(), changePassword.getText().toString());
        }
        else if(!(changeName.getText().toString().equals("")) && (changeUsername.getText().toString().equals("")) && (changePassword.getText().toString().equals(""))){
            x = dhelper.updateHandler(changeName.getText().toString(), customer.getEmail(), customer.getPassword());
        }
        else if(!(changeName.getText().toString().equals("")) && !(changeUsername.getText().toString().equals("")) && (changePassword.getText().toString().equals(""))){
            x = dhelper.updateHandler(changeName.getText().toString(), changeUsername.getText().toString(), customer.getPassword());
        }
        else if(!(changeName.getText().toString().equals("")) && (changeUsername.getText().toString().equals("")) && !(changePassword.getText().toString().equals(""))){
            x = dhelper.updateHandler(changeName.getText().toString(), customer.getEmail(), changePassword.getText().toString());
        }
        else if((changeName.getText().toString().equals("")) && !(changeUsername.getText().toString().equals("")) && !(changePassword.getText().toString().equals(""))){
            x = dhelper.updateHandler(customer.getName(), changeUsername.getText().toString(), changePassword.getText().toString());
        }
        else if((changeName.getText().toString().equals("")) && !(changeUsername.getText().toString().equals("")) && (changePassword.getText().toString().equals(""))){
            x = dhelper.updateHandler(customer.getName(), changeUsername.getText().toString(), customer.getPassword());
        }
        else if((changeName.getText().toString().equals("")) && (changeUsername.getText().toString().equals("")) && !(changePassword.getText().toString().equals(""))){
            x = dhelper.updateHandler(customer.getName(), customer.getEmail().toString(), changePassword.getText().toString());
        }
        else if((changeName.getText().toString().equals("")) && (changeUsername.getText().toString().equals("")) && (changePassword.getText().toString().equals(""))){
            x = dhelper.updateHandler(customer.getName(), customer.getEmail(), customer.getPassword());
        }

        return x;
    }

}
