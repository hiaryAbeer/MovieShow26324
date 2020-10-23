package com.movieapp.movieapp.ViewModel;

import com.movieapp.movieapp.models.BaseData;
import com.movieapp.movieapp.models.PlansModel;
import com.movieapp.movieapp.repository.PlansRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlansViewModel extends ViewModel {

    MutableLiveData<PlansModel> plansMutableLiveData;

    public LiveData<PlansModel> getPlansMutableLiveData() {
        return plansMutableLiveData;
    }

    public void initialization(){
        if (plansMutableLiveData != null)
            return;

        plansMutableLiveData = PlansRepository.getInstance().getPlansData();

    }
}
