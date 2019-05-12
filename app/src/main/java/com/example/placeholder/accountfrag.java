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

//ACCOUNT TAB

public class accountfrag extends Fragment {

    private static final String Tag = "ACCOUNT";

    //create variables for the buttons in the layout
    private Button settings;
    private Button logout;
    private Button viewT;

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.account, container, false);

        //link buttons to id of elements in layout
        settings = view.findViewById(R.id.settings);
        logout = view.findViewById(R.id.logout);
        viewT = view.findViewById(R.id.viewTables);


        //settings button redirects to settings activity when clicked
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), settings.class);
                startActivity(intent);
            }
        });

        //logout button redirects back to main page
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        //TEMPORARY-TESTING PURPOSES / For admins only
        //view button redirects to page where you can view the database tables
        viewT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ViewDatabase.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
