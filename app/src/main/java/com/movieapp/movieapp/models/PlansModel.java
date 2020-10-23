package com.movieapp.movieapp.models;

import com.google.gson.annotations.SerializedName;
import com.movieapp.movieapp.BR;

import java.util.List;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class PlansModel extends BaseObservable{
    @SerializedName("response")
    private int response;

    @SerializedName("plans")
    private List<PlansModel> modelList;

    @SerializedName("duration")
    private String duration;

    @SerializedName("price")
    private String priceBefore;

    @SerializedName("price_after")
    private String priceAfter;

    @SerializedName("plan_type")
    private String offerType;

    @SerializedName("offer_message")
    private String offerMessage;

    @SerializedName("resolution")
    private String resolution;

    @SerializedName("no_of_devices")
    private String noOfDevices;


    public PlansModel() {
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public List<PlansModel> getModelList() {
        return modelList;
    }

    public void setModelList(List<PlansModel> modelList) {
        this.modelList = modelList;
    }

    @Bindable
    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
        notifyPropertyChanged(BR.resolution);
    }

    @Bindable
    public String getNoOfDevices() {
        return noOfDevices;
    }

    public void setNoOfDevices(String noOfDevices) {
        this.noOfDevices = noOfDevices;
        notifyPropertyChanged(BR.noOfDevices);
    }

    @Bindable
    public String getOfferMessage() {
        return offerMessage;
    }

    public void setOfferMessage(String offerMessage) {
        this.offerMessage = offerMessage;
        notifyPropertyChanged(BR.offerMessage);
    }

    @Bindable
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
        notifyPropertyChanged(BR.duration);
    }

    @Bindable
    public String getPriceBefore() {
        return priceBefore;
    }

    public void setPriceBefore(String priceBefore) {
        this.priceBefore = priceBefore;
        notifyPropertyChanged(BR.priceBefore);
    }

    @Bindable
    public String getPriceAfter() {
        return priceAfter;
    }

    public void setPriceAfter(String priceAfter) {
        this.priceAfter = priceAfter;
        notifyPropertyChanged(BR.priceAfter);
    }

    @Bindable
    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
        notifyPropertyChanged(BR.offerType);
    }
}

