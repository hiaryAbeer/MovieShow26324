package com.movieapp.movieapp.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MoviesByGenresModel implements Serializable {
//    {
//        "page": 1,
//            "total_results": 10000,
//            "total_pages": 500,
//            "results": [
//        {
//            "popularity": 2408.848,
//                "vote_count": 165,
//                "video": false,
//                "poster_path": "/7D430eqZj8y3oVkLFfsWXGRcpEG.jpg",
//                "id": 528085,
//                "adult": false,
//                "backdrop_path": "/5UkzNSOK561c2QRy2Zr4AkADzLT.jpg",
//                "original_language": "en",
//                "original_title": "2067",
//                "genre_ids": [
//            18,
//                    878,
//                    53
//      ],
//            "title": "2067",
//                "vote_average": 5.7,
//                "overview": "A lowly utility worker is called to the future by a mysterious radio signal, he must leave his dying wife to embark on a journey that will force him to face his deepest fears in an attempt to change the fabric of reality and save humankind from its greatest environmental crisis yet.",
//                "release_date": "2020-10-01"
//        }
//        ]
//    }

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("vote_count")
    private int vote_count;

    @SerializedName("video")
    private boolean video;

    @SerializedName("poster_path")
    private String poster_path;

    @SerializedName("id")
    private long id;

    @SerializedName("adult")
    private boolean adult;

    @SerializedName("backdrop_path")
    private String backdrop_path;

    @SerializedName("original_language")
    private String original_language;

    @SerializedName("original_title")
    private String original_title;

    @SerializedName("genre_ids")
    private List<Integer> genre_ids;

    @SerializedName("title")
    private String title;

    @SerializedName("vote_average")
    private double vote_average;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String release_date;

    private boolean like = false;

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}
