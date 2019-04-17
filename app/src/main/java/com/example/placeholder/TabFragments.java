package com.example.placeholder;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class TabFragments extends AppCompatActivity {
    private static final String tag = "Tabs";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;

    //this class basically just creates the tab fragments for menu, orders and account
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_fragments);
        Log.d(tag, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    //creates the tabs
    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
            adapter.addFragment(new menufrag(), "MENU");
            adapter.addFragment(new ordersfrag(), "ORDERS");
            adapter.addFragment(new accountfrag(), "ACCOUNT");

            viewPager.setAdapter(adapter);

    }


}
