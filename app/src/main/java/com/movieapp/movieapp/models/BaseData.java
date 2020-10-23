package com.movieapp.movieapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseData {

    @SerializedName("result")
    private List<UsersModel> usersModels;

    public List<UsersModel> getUsersModels() {
        return usersModels;
    }

    @SerializedName("plans")
    private List<PlansModel> plansModel;

    public List<PlansModel> getPlansModel() {
        return plansModel;
    }

//    @SerializedName("plans_result")
//    private String response;
//
//    public String getResponse() {
//        return response;
//    }
}
