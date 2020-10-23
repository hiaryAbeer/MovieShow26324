package com.movieapp.movieapp.repository;

import android.util.Log;

import com.movieapp.movieapp.JsonPlaceHolder;
import com.movieapp.movieapp.RetrofitClass;
import com.movieapp.movieapp.ShareClass;
import com.movieapp.movieapp.models.BaseData;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersRepository {

    private static UsersRepository instance;
    private JsonPlaceHolder placeHolder;

    public static UsersRepository getInstance() {
        if (instance == null)
            instance = new UsersRepository();

        return instance;
    }

    public UsersRepository() {
        placeHolder = RetrofitClass.createService(JsonPlaceHolder.class);
    }

    public MutableLiveData<BaseData> getUsersData() {
        MutableLiveData<BaseData> data = new MutableLiveData<>();

        placeHolder.getUsers().enqueue(new Callback<BaseData>() {
            @Override
            public void onResponse(Call<BaseData> call, Response<BaseData> response) {
                if (response.isSuccessful())
                    data.setValue(response.body());
                else
                    new ShareClass().showLog("UsersRepository", "getUsersData", response.errorBody().toString());
            }

            @Override
            public void onFailure(Call<BaseData> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
