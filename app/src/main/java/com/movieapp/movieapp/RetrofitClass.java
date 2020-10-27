package com.movieapp.movieapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private static Retrofit retrofit= new Retrofit.Builder()
            .baseUrl("https://fullmovieapp.000webhostapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    private static Retrofit retrofit2 = new Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

    public static <S> S createService2(Class<S> serviceClass){
        return retrofit2.create(serviceClass);

    }

}
