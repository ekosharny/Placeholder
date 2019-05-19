package com.example.placeholder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_menu:
                    mTextMessage.setText("Menu");
                    return true;
                case R.id.navigation_featured:
                    mTextMessage.setText("Featured");
                    return true;
                case R.id.navigation_cart:
                    mTextMessage.setText("Cart");
                    return true;
            }
            return false;
        }
    };

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menulist, menu);
            setTitle("PlaceHolder");
            return true;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Toolbar toolbar= findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            BottomNavigationView navigation = findViewById(R.id.navigation);
            navigation.setOnNavigationItemSelectedListener(navListener);

            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new menufrag()).commit();
        }

        private BottomNavigationView.OnNavigationItemSelectedListener navListener=
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        Fragment selectedFragment = null;
                        switch(menuItem.getItemId()){
                            case R.id.navigation_menu:
                                selectedFragment=new menufrag();
                                break;
                            case R.id.navigation_featured:
                                selectedFragment= new ordersfrag();
                                break;
                            case R.id.navigation_cart:
                                selectedFragment = new cartfrag();
                                break;

                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                                selectedFragment).commit();
                        return true;
                    }
                };

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch(item.getItemId()) {
                case R.id.notification_icon:
                    Toast.makeText(this, "Notifications", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.dropdown_account:
                    Toast.makeText(this, "account", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, account.class));
                    return true;
                case R.id.dropdown_previous:
                    Toast.makeText(this, "Previous Orders", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.dropdown_settings:
                    Intent intent4 = new Intent(this, settings.class);
                    startActivity(intent4);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

}

