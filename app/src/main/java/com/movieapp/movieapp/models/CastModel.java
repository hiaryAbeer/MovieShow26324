package com.movieapp.movieapp.models;

import com.google.gson.annotations.SerializedName;

public class CastModel {
//    {
//        "id": 516486,
//            "cast": [
//        {
//            "cast_id": 1,
//                "character": "Commander Krause",
//                "credit_id": "5ac6db57c3a36834de01a435",
//                "gender": 2,
//                "id": 31,
//                "name": "Tom Hanks",
//                "order": 0,
//                "profile_path": "/mKr8PN8sn80LzVaZMg8L52kmakm.jpg"
//        } ] }

    @SerializedName("cast_id")
    private int cast_id;

    @SerializedName("character")
    private String character;

    @SerializedName("credit_id")
    private String credit_id;

    @SerializedName("gender")
    private int gender;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("order")
    private int order;

    @SerializedName("profile_path")
    private String profile_path;

    public int getCast_id() {
        return cast_id;
    }

    public String getCharacter() {
        return character;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public int getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    public String getProfile_path() {
        return profile_path;
    }
}
