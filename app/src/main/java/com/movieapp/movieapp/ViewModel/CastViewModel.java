package com.movieapp.movieapp.ViewModel;

import com.movieapp.movieapp.models.BaseData;
import com.movieapp.movieapp.repository.CastRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CastViewModel extends ViewModel {
    private MutableLiveData<BaseData> data;

    public LiveData<BaseData> getData() {
        return data;
    }

    public void initialization(long id){
        if (data != null)
            return;

        data =  CastRepository.getInstance().getCastRepository(id);

    }
}
