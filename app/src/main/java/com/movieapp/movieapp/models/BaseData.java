package com.movieapp.movieapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseData {

    @SerializedName("results")
    private List<MoviesByGenresModel> moviesByGenresModelList;

    public List<MoviesByGenresModel> getMoviesByGenresModelList() {
        return moviesByGenresModelList;
    }

    @SerializedName("plans")
    private List<PlansModel> plansModel;

    public List<PlansModel> getPlansModel() {
        return plansModel;
    }

    //https://api.themoviedb.org/3/genre/movie/list?api_key=b5b8cadf0bba0bcc88b21fbfe198561a&language=en-US
    @SerializedName("genres")
    private List<MovieGeners> movieGeners;

    public List<MovieGeners> getMovieGeners() {
        return movieGeners;
    }

    //    @SerializedName("plans_result")
//    private String response;
//
//    public String getResponse() {
//        return response;
//    }
}
