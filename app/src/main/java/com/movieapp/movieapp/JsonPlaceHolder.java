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

    //https://api.themoviedb.org/3/genre/movie/list?api_key=b5b8cadf0bba0bcc88b21fbfe198561a&language=en-US
    @GET("genre/movie/list?api_key=b5b8cadf0bba0bcc88b21fbfe198561a&language=en-US")
    Call<BaseData> getMoviesGeneric();

    //https://api.themoviedb.org/3/discover/movie?api_key=b5b8cadf0bba0bcc88b21fbfe198561a&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1
    @GET("discover/movie?api_key=b5b8cadf0bba0bcc88b21fbfe198561a&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    Call<BaseData> getMoviesByGenres();
}
