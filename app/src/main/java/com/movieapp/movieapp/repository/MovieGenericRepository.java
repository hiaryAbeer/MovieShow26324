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

public class MovieGenericRepository {

    private static MovieGenericRepository instance;
    private JsonPlaceHolder holder;

    private MovieGenericRepository() {
        holder = RetrofitClass.createService2(JsonPlaceHolder.class);
    }

    public static MovieGenericRepository getInstance(){
        if (instance == null)
            instance = new MovieGenericRepository();
        return instance;
    }

    public MutableLiveData<BaseData> getGenericMovies(){
        MutableLiveData<BaseData> data = new MutableLiveData<>();
        holder.getMoviesGeneric().enqueue(new Callback<BaseData>() {
            @Override
            public void onResponse(Call<BaseData> call, Response<BaseData> response) {
                Log.e("genericMovies", response.body().toString());

                if (response.isSuccessful())
                    data.setValue(response.body());
                else
                    new ShareClass().showLog("MovieGenericRepository", "getGenericMovies" ,"" +  response.errorBody());

            }

            @Override
            public void onFailure(Call<BaseData> call, Throwable t) {
                Log.e("genericMovies:e", t.getMessage());
                data.setValue(null);

            }
        });
        return data;
    }

}
