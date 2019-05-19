package com.example.placeholder;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class cartfrag extends Fragment{

    TextView checkOutItems;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_cart,container,false);

        checkOutItems=view.findViewById(R.id.itemsTV);

        DatabaseHelper dbHandler = new DatabaseHelper(getActivity());
        checkOutItems.setText(dbHandler.loadDetails());

        return view;
    }


}