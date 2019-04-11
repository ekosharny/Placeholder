package com.example.placeholder;

import android.support.v7.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    /*
    DatabaseHelper mDatabaseHelper;
    private EditText name, email, password;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.nameInput);
        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);
        signup = findViewById(R.id.signUpButton);

        mDatabaseHelper = new DatabaseHelper(this);

        signup.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String newName = name.getText().toString();
                if(name.length() != 0){
                    AddData(newName);
                    name.setText("");
                }
                else{
                    toastMessage("You must put something in the textfield");
                }
            }
        });

    }

    public void AddData(String newEntry){

        boolean insertData = mDatabaseHelper.addData(newEntry);

        if(insertData)
            toastMessage("Success!");
        else
            toastMessage("Something went wrong");

    }
    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
*/
}
