package com.movieapp.movieapp;

import com.movieapp.movieapp.models.BaseData;
import com.movieapp.movieapp.models.MovieVideoModel;
import com.movieapp.movieapp.models.PlansModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

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

    @GET("movie/{movie_id}/credits?api_key=b5b8cadf0bba0bcc88b21fbfe198561a")
    Call<BaseData> getMovieCast(@Path("movie_id") long id);

    //https://api.themoviedb.org/3/movie/{movie_id}/videos?api_key=b5b8cadf0bba0bcc88b21fbfe198561a&language=en-US
    @GET("movie/{movie_id}/videos?api_key=b5b8cadf0bba0bcc88b21fbfe198561a&language=en-US")
    Call<MovieVideoModel> getMovieVideo(@Path("movie_id") long id);
}
