package com.example.placeholder;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ordersfrag extends Fragment {

    TextView orders;

    private static final String Tag = "ORDERS";
    @Nullable
    //@Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.orders, container, false);

        orders = view.findViewById(R.id.previousOrders);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String e="";
        if (user != null) {
            e = user.getEmail();
        }

        DatabaseHelper dhelper = new DatabaseHelper(getActivity());
        orders.setText(dhelper.loadOrders(e));


        return view;
    }
}
