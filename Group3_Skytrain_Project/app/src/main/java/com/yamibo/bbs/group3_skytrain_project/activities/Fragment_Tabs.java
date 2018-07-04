package com.yamibo.bbs.group3_skytrain_project.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yamibo.bbs.group3_skytrain_project.R;
import com.yamibo.bbs.group3_skytrain_project.adapter.SwipeTabsAdapter;

public class Fragment_Tabs extends Fragment {
    View v;
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceStat){
        v=inflater.inflate(R.layout.swipe_tabs_layout,container,false);
        viewPager=(ViewPager)v.findViewById(R.id.viewPagerForTabs);
        viewPager.setAdapter(new SwipeTabsAdapter(getChildFragmentManager()));

        tabLayout=(TabLayout)v.findViewById(R.id.tabLayout);
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        return v;
    }
    @Override
    public void onViewCreated(View v,Bundle savedInstanceStat){
        viewPager=(ViewPager)v.findViewById(R.id.viewPagerForTabs);
        viewPager.setAdapter(new SwipeTabsAdapter(getChildFragmentManager()));

        tabLayout=(TabLayout)v.findViewById(R.id.tabLayout);
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Activity main=new MainActivity();
        if(context instanceof Activity){
            main=(Activity)context;
        }
    }
}