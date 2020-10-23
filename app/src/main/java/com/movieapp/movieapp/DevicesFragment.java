package com.movieapp.movieapp;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movieapp.movieapp.databinding.FragmentDevicesBinding;
import com.movieapp.movieapp.models.FragmentModel;

public class DevicesFragment extends Fragment {

    private int pageFlag = 0;
    FragmentModel fragmentModel;
    FragmentDevicesBinding binding;

    public DevicesFragment() {
        // Required empty public constructor
    }

    public DevicesFragment(int pageFlag) {
        this.pageFlag = pageFlag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        switch (pageFlag){
            case 1:
                fragmentModel = new FragmentModel(getString(R.string.devices_hint), getString(R.string.devices_message), getResources().getDrawable(R.drawable.devices));
                break;
            case 2:
                fragmentModel = new FragmentModel(getString(R.string.contract_title), getString(R.string.contract_message), getResources().getDrawable(R.drawable.no_contract));
                break;
            case 3:
                fragmentModel = new FragmentModel(getString(R.string.movies_title),getString(R.string.movies_message), getResources().getDrawable(R.drawable.movies));
                break;

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_devices, container, false);

//        Log.e("fragment", fragmentModel.getText());
        binding.setFragmentModel(fragmentModel);

        return binding.getRoot();
    }
}