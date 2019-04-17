package com.example.placeholder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class menufrag extends Fragment{
    private static final String Tag = "MENU";

    //creates variables for image buttons in menu tab

    private ImageButton bowls;
    private ImageButton drinks;
    private ImageButton sides;
    private ImageButton desserts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu,container,false);

        //links variables to the id in layout
        bowls = view.findViewById(R.id.bowlsButton);
        drinks =  view.findViewById(R.id.drinksButton);
        sides =  view.findViewById(R.id.sidesButton);
        desserts = view.findViewById(R.id.dessertsButton);



        //redirects to bowls page when clicked
        bowls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), bowls.class);
                startActivity(intent);
            }
        });

        //redirects to drinks page when clicked
        drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), drinks.class);
                startActivity(intent);
            }
        });

        //redirects to sides page when clicked
        sides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), sides.class);
                startActivity(intent);
            }
        });

        //redirects to desserts page when clicked
        desserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), desserts.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
