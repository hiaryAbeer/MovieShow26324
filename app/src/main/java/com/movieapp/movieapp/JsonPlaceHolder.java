package com.movieapp.movieapp;

import com.movieapp.movieapp.models.BaseData;
import com.movieapp.movieapp.models.PlansModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface JsonPlaceHolder {

    //https://fullmovieapp.000webhostapp.com/
    @POST("LoginFile.php?_ijt=thtn9p4f72bjff0hesthujef96")
    Call<BaseData> getUsers();

//    https://fullmovieapp.000webhostapp.com/PlansFile.php
    @GET("PlansFile.php")
    Call<PlansModel> getPlans();
}
