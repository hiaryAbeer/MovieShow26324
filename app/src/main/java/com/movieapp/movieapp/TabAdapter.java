package com.movieapp.movieapp;

import android.util.Log;

import com.movieapp.movieapp.models.MovieGeners;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {

    private List<MovieGeners> list;

    public TabAdapter(@NonNull FragmentManager fm, List<MovieGeners> list) {
        super(fm);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Log.e("position", "" + position);
        return TabsFragment.newInstance(list.get(position).getName(), list.get(position).getId());
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Log.e("name", list.get(position).getName());
        return list.get(position).getName();
    }
}
