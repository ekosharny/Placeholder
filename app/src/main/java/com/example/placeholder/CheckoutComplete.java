package com.example.placeholder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CheckoutComplete extends AppCompatActivity {

    Button returnToMenu;
    TextView orderoutput,orderprice, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_complete);

        orderoutput = findViewById(R.id.checkedout);
        orderprice = findViewById(R.id.checkedoutprice);
        total = findViewById(R.id.totalcomplete);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String e="";
        if (user != null) {
            e = user.getEmail();
        }

        DatabaseHelper dbHandler = new DatabaseHelper(this);
        orderoutput.setText(dbHandler.loadItems(e));
        orderprice.setText(dbHandler.loadPrices(e));

        double d = dbHandler.addPrices(e);

        total.setText("TOTAL:  $"+ String.valueOf(d) + "0");

        returnToMenu = findViewById(R.id.returnToMenuButton);

        returnToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean x = deleteItems();
                total.setText("");
                startActivity(new Intent(CheckoutComplete.this, MainActivity.class));
                finish();
            }
        });
    }
    public boolean deleteItems(){
        //creates new DatabaseHelper and calls deleteHandler
        DatabaseHelper dhelper = new DatabaseHelper(this);
        boolean x = dhelper.deleteDetails(1);
        return x;
    }

}
