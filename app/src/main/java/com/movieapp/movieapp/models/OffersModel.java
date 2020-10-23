package com.movieapp.movieapp.models;

public class OffersModel {

    private String duration;
    private String priceBefore;
    private String priceAfter;
    private String offerType;
    private String offerMessage;

    public OffersModel() {
    }

    public String getOfferMessage() {
        return offerMessage;
    }

    public void setOfferMessage(String offerMessage) {
        this.offerMessage = offerMessage;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPriceBefore() {
        return priceBefore;
    }

    public void setPriceBefore(String priceBefore) {
        this.priceBefore = priceBefore;
    }

    public String getPriceAfter() {
        return priceAfter;
    }

    public void setPriceAfter(String priceAfter) {
        this.priceAfter = priceAfter;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }
}
