package com.example.myapplication.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import com.example.myapplication.fragments.AddFragment;
import com.example.myapplication.fragments.ListFragment;

import java.util.ArrayList;

public class ViewPagerAdapter  extends FragmentStateAdapter {
    ArrayList<Fragment> arrayList = new ArrayList<>();


    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment= new Fragment();
        switch (position){
            case 0:
                fragment = new ListFragment();
                break;
            case 1:
                fragment = new AddFragment();
                break;

        }
        return  fragment;

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public void addFragment(Fragment fragment) {
        arrayList.add(fragment);
    }
}
