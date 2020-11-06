package com.movieapp.movieapp.repository;

import com.movieapp.movieapp.JsonPlaceHolder;
import com.movieapp.movieapp.RetrofitClass;
import com.movieapp.movieapp.ShareClass;
import com.movieapp.movieapp.models.BaseData;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CastRepository {
    private static CastRepository instance;
    private JsonPlaceHolder holder;

    public static CastRepository getInstance() {
        if (instance == null)
            instance = new CastRepository();
        return instance;
    }

    private CastRepository() {
        holder = RetrofitClass.createService2(JsonPlaceHolder.class);

    }

    public MutableLiveData<BaseData> getCastRepository(long id){
        MutableLiveData<BaseData> data = new MutableLiveData<>();
        holder.getMovieCast(id).enqueue(new Callback<BaseData>() {
            @Override
            public void onResponse(Call<BaseData> call, Response<BaseData> response) {
                if (response.isSuccessful())
                    data.setValue(response.body());
                else
                    new ShareClass().showLog("CastRepository ", "getCastRepository" , response.message());
            }

            @Override
            public void onFailure(Call<BaseData> call, Throwable t) {
                data.setValue(null);

            }
        });
        return data;
    }
}
