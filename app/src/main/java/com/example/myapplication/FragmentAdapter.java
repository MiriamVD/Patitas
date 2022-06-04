package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.fragments.AddFragment;
import com.example.myapplication.fragments.MapFragment;

public class FragmentAdapter extends FragmentStateAdapter {
    private String [] titles = new String[]{"Mapa", "Agregar"};

    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {

        super(fragmentActivity);

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new MapFragment();
            case 1:
                return new AddFragment();
        }
        return new MapFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
