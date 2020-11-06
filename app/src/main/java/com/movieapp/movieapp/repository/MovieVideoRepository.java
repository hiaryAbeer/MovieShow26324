package com.movieapp.movieapp.repository;

import com.movieapp.movieapp.JsonPlaceHolder;
import com.movieapp.movieapp.RetrofitClass;
import com.movieapp.movieapp.ShareClass;
import com.movieapp.movieapp.models.BaseData;
import com.movieapp.movieapp.models.MovieVideoModel;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieVideoRepository {
    private static MovieVideoRepository instance;
    private JsonPlaceHolder holder;

    public static MovieVideoRepository getInstance() {
        if (instance == null)
            instance = new MovieVideoRepository();
        return instance;
    }

    private MovieVideoRepository() {
        holder = RetrofitClass.createService2(JsonPlaceHolder.class);
    }

    public MutableLiveData<MovieVideoModel> playMovieRepository(long id){
        MutableLiveData<MovieVideoModel> data = new MutableLiveData<>();
        holder.getMovieVideo(id).enqueue(new Callback<MovieVideoModel>() {
            @Override
            public void onResponse(Call<MovieVideoModel> call, Response<MovieVideoModel> response) {
                if (response.isSuccessful())
                    data.setValue(response.body());
                else
                    new ShareClass().showLog("MovieVideoRepository", "playMovieRepository" ,response.message());
            }

            @Override
            public void onFailure(Call<MovieVideoModel> call, Throwable t) {
                data.setValue(null);

            }
        });

        return data;
    }
}
