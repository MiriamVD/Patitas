package com.example.myapplication;

import android.os.Bundle;


import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;


public class AnimalesPerdidos extends AppCompatActivity {

    FragmentAdapter adapter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    private String [] titles = new String[]{"Mapa", "Agregar"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tabLayout=findViewById(R.id.tabLayout);
        viewPager2=findViewById(R.id.viewPager);
        getSupportActionBar().hide();;


        adapter=new FragmentAdapter(this);
        viewPager2.setAdapter(adapter);

    new TabLayoutMediator(tabLayout,viewPager2,((tab, position) ->tab.setText(titles[position]))).attach();



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager2.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    });


    }
}