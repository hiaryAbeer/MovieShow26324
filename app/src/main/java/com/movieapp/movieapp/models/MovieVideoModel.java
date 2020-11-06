package com.movieapp.movieapp.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MovieVideoModel implements Serializable {
//    {
//        "id": 550,
//            "results": [
//        {
//            "id": "533ec654c3a36854480003eb",
//                "iso_639_1": "en",
//                "iso_3166_1": "US",
//                "key": "SUXWAEX2jlg",
//                "name": "Trailer 1",
//                "site": "YouTube",
//                "size": 720,
//                "type": "Trailer"
//        }
//  ]
//    }

    @SerializedName("results")
    private List<MovieVideoModel> videoModels;

    public List<MovieVideoModel> getVideoModels() {
        return videoModels;
    }

    @SerializedName("id")
    private String videoId;

    @SerializedName("iso_639_1")
    private String iso_639_1;

    @SerializedName("iso_3166_1")
    private String iso_3166_1;

    @SerializedName("key")
    private String key;

    @SerializedName("name")
    private String name;

    @SerializedName("site")
    private String site;

    @SerializedName("size")
    private long size;

    @SerializedName("type")
    private String type;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getIso_639_1() {
        return iso_639_1;
    }

    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }

    public String getIso_3166_1() {
        return iso_3166_1;
    }

    public void setIso_3166_1(String iso_3166_1) {
        this.iso_3166_1 = iso_3166_1;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
