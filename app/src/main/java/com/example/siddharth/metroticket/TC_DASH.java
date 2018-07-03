package com.example.siddharth.metroticket;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TC_DASH extends AppCompatActivity {

    ViewPager Tab;
    TabPagerAdapter TabAdapter;
    ActionBar actionBar;
    TextView txt1;
    EditText ed1;
    Button b,b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tc__dash);
        TabAdapter = new TabPagerAdapter(getSupportFragmentManager());

        txt1= (TextView) findViewById(R.id.txt1);
        ed1= (EditText) findViewById(R.id.ed1);
        b1= (Button) findViewById(R.id.b1);

        b= (Button) findViewById(R.id.b);
     /*   b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(TC_DASH.this,Checking.class);
                startActivity(intent);
            }
        });*/

        Tab = (ViewPager)findViewById(R.id.pager);
        Tab.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {

                        actionBar = getSupportActionBar();
                        actionBar.setSelectedNavigationItem(position);                    }
                });
        Tab.setAdapter(TabAdapter);

        actionBar = getSupportActionBar();
        //Enable Tabs on Action Bar
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

                Tab.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };
        //Add New Tab
        actionBar.addTab(actionBar.newTab().setText("CHECK-TICKET").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("FINE").setTabListener(tabListener));

    }

}
