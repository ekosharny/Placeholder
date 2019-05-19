package com.example.placeholder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class cartfrag extends Fragment{

    TextView items, prices, total;
    Button clear, checkout;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_cart,container,false);

        //checkOutItems=view.findViewById(R.id.itemsTV);

        items = view.findViewById(R.id.items);
        prices = view.findViewById(R.id.prices);
        clear = view.findViewById(R.id.clear);
        checkout = view.findViewById(R.id.checkout);
        total = view.findViewById(R.id.totalOutput);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String e="";
        if (user != null) {
            e = user.getEmail();
        }

        DatabaseHelper dbHandler = new DatabaseHelper(getActivity());
        items.setText(dbHandler.loadItems(e));
        prices.setText(dbHandler.loadPrices(e));
        double d = dbHandler.addPrices(e);

        total.setText("$"+ String.valueOf(d) + "0");


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean x = deleteItems();
                if(x=true){
                    items.setText("");
                    prices.setText("");
                    total.setText("");
                }
                else
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();

            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String e="";
                if (user != null) {
                    e = user.getEmail();
                }
                DatabaseHelper dhelper = new DatabaseHelper(getActivity());
                dhelper.copyOrders(e);

                Intent intent = new Intent(getActivity(), CheckoutComplete.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public boolean deleteItems(){
        //creates new DatabaseHelper and calls deleteHandler
        DatabaseHelper dhelper = new DatabaseHelper(getActivity());
        boolean x = dhelper.deleteDetails(1);
        return x;
    }

}