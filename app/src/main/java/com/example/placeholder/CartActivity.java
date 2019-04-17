package com.example.placeholder;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity{


    private ShoppingCart cart2 =new ShoppingCart();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        TextView itemName;

        setContentView(R.layout.activity_cart);
        itemName=findViewById(R.id.textView6);
        itemName.setText("bowl");

        Button rmvCrtBtn= (Button) findViewById(R.id.rmvCrtBtn);
        rmvCrtBtn.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view){
                int x=0;
            }

        });



    }

}