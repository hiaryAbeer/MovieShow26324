package com.movieapp.movieapp.repository;

import android.util.Log;

import com.movieapp.movieapp.JsonPlaceHolder;
import com.movieapp.movieapp.RetrofitClass;
import com.movieapp.movieapp.ShareClass;
import com.movieapp.movieapp.models.BaseData;
import com.movieapp.movieapp.models.PlansModel;

import androidx.lifecycle.MutableLiveData;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlansRepository {

    private static PlansRepository instance;
    private JsonPlaceHolder placeHolder;

    public PlansRepository() {
        placeHolder = RetrofitClass.createService(JsonPlaceHolder.class);

    }

    public static PlansRepository getInstance(){
        if (instance == null)
            instance = new PlansRepository();
        return instance;
    }

    public MutableLiveData<PlansModel> getPlansData(){
        MutableLiveData<PlansModel> data = new MutableLiveData<>();
        placeHolder.getPlans().enqueue(new Callback<PlansModel>() {
            @Override
            public void onResponse(Call<PlansModel> call, Response<PlansModel> response) {
//                try {
                    Log.e("plans", "" + response.body().getResponse());
//                }catch (Exception e){
//                Log.e("plans", e.getMessage());
//                }


                if (response.isSuccessful())
                    data.setValue(response.body());
                else
                    new ShareClass().showLog("PlansRepository", "getPlansData ", response.message());
            }

            @Override
            public void onFailure(Call<PlansModel> call, Throwable t) {
                Log.e("plans:e", t.getMessage());
                data.setValue(null);

            }
        });
        return data;
    }


}