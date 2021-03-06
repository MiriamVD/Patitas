package com.example.myapplication.adapters;

import android.os.Bundle;


import com.example.myapplication.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;


public class AnimalesPerdidos extends AppCompatActivity {

    ViewPagerAdapter madapter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales_perdidos);
        setTitle("Animales Perdidos");
        madapter=new ViewPagerAdapter(getSupportFragmentManager(),getLifecycle());

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setAdapter(madapter);

        int[] icon = new int[]{
                R.drawable.list2_icon,
                R.drawable.pet_icon

        };
        new TabLayoutMediator(tabLayout,viewPager2,(tab, position) -> tab.setIcon(icon[position])).attach();


    }


}