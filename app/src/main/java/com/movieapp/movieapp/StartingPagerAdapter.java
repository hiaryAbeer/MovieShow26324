package com.movieapp.movieapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class StartingPagerAdapter extends FragmentStateAdapter {

    public StartingPagerAdapter(@NonNull FragmentActivity fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new DevicesFragment(1);// devices
            case 1:
                return new DevicesFragment(2);// contract
            case 2:
                return new DevicesFragment(3);// movies
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
