package com.example.placeholder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class menufrag extends Fragment{
    private static final String Tag = "MENU";

    private Button bowls;
    private Button drinks;
    private Button sides;
    private Button desserts;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu,container,false);
        bowls = (Button) view.findViewById(R.id.bowls);
        drinks = (Button) view.findViewById(R.id.drinks);
        sides = (Button) view.findViewById(R.id.sides);
        desserts = (Button) view.findViewById(R.id.desserts);



        bowls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), bowls.class);
                startActivity(intent);
            }
        });
        drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), drinks.class);
                startActivity(intent);
            }
        });
        sides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), sides.class);
                startActivity(intent);
            }
        });
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
