package com.movieapp.movieapp.models;

import com.google.gson.annotations.SerializedName;

public class MovieGeners {

    //https://api.themoviedb.org/3/genre/movie/list?api_key=b5b8cadf0bba0bcc88b21fbfe198561a&language=en-US
//    {
//        "genres": [
//        {
//            "id":28,
//                "name":"Action"
//        }
//        ]
//    }
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
