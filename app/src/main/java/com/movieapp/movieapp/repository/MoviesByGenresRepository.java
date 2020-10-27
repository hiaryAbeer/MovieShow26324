package com.movieapp.movieapp.repository;

import com.movieapp.movieapp.JsonPlaceHolder;
import com.movieapp.movieapp.RetrofitClass;
import com.movieapp.movieapp.ShareClass;
import com.movieapp.movieapp.models.BaseData;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesByGenresRepository {
    private static MoviesByGenresRepository instance;
    private JsonPlaceHolder holder;

    public MoviesByGenresRepository() {
        holder = RetrofitClass.createService2(JsonPlaceHolder.class);
    }

    public static MoviesByGenresRepository getInstance(){
        if (instance == null)
            instance = new MoviesByGenresRepository();
        return instance;
    }

    public MutableLiveData<BaseData> getMoviesByGenresRepository(){
        MutableLiveData<BaseData> data = new MutableLiveData<>();
        holder.getMoviesByGenres().enqueue(new Callback<BaseData>() {
            @Override
            public void onResponse(Call<BaseData> call, Response<BaseData> response) {
                if (response.isSuccessful())
                    data.setValue(response.body());
                else
                    new ShareClass().showLog("MoviesByGenresRepository", "getMoviesByGenresRepository",  response.message());

            }

            @Override
            public void onFailure(Call<BaseData> call, Throwable t) {
                new ShareClass().showLog("MoviesByGenresRepository:e", "getMoviesByGenresRepository",  t.getMessage());
                data.setValue(null);

            }
        });
        return data;
    }
}
