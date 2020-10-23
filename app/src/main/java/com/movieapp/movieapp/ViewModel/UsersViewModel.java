package com.movieapp.movieapp.ViewModel;

import com.movieapp.movieapp.models.BaseData;
import com.movieapp.movieapp.repository.UsersRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UsersViewModel extends ViewModel {

    private MutableLiveData<BaseData> usersLiveData;

    public LiveData<BaseData> getUsersLiveData() {
        return usersLiveData;
    }

    public void initialization() {
        if (usersLiveData != null)
            return;

        usersLiveData = UsersRepository.getInstance().getUsersData();
    }
}
