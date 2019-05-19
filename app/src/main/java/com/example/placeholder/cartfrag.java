package com.example.placeholder;

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

public class cartfrag extends Fragment{

    TextView items, prices;
    Button clear, checkout;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_cart,container,false);

        //checkOutItems=view.findViewById(R.id.itemsTV);

        items = view.findViewById(R.id.items);
        prices = view.findViewById(R.id.prices);
        clear = view.findViewById(R.id.clear);
        checkout = view.findViewById(R.id.checkout);


        DatabaseHelper dbHandler = new DatabaseHelper(getActivity());
        items.setText(dbHandler.loadItems());
        prices.setText(dbHandler.loadPrices());

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean x = deleteItems();
                if(x=true){
                    items.setText("");
                    prices.setText("");
                }
                else
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();

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