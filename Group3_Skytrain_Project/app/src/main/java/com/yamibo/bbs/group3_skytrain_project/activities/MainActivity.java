package com.yamibo.bbs.group3_skytrain_project.activities;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.yamibo.bbs.group3_skytrain_project.R;

public class MainActivity extends AppBaseActivity {
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private android.app.Fragment tripFrag;
    private android.app.Fragment transitFrag;
    private android.app.Fragment feedFrag;
    private CollapsingToolbarLayout collapsyToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        setTabsFragment(new Fragment_Tabs());
        initTabFragments();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NearbyActivity.class);
                startActivity(intent);
            }
        });
    }
    public void setToolbar(){
        toolbar=(Toolbar)findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("TransLink");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setSubtitle("Data by TransLink");
    }

    private void setTabsFragment(Fragment fragment){
        //Always use v4.app.FragmentTransaction
        if(fragment!=null){
            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.rootViewPager,new Fragment_Tabs()).commit();
        }
        //Uncomment the drawerLayout declaration below in case
        // of the combination of drawer and swiping tabs
       /* DrawerLayout drawer =(DrawerLayout)findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);*/
    }
    private void initTabFragments(){
        tripFrag=getFragmentManager().findFragmentById(R.layout.tab_trip_plan);
        transitFrag=getFragmentManager().findFragmentById(R.layout.tab_transit);
        feedFrag=getFragmentManager().findFragmentById(R.layout.tab_trans_feed);
    }
}
