package com.example.puza.mvpapiimplementation.application.network.TopPlacesDao;

public class TopPlaces {

    private int topPlaceImage;
    private String topPlaceTitle;

    public TopPlaces(int topPlaceImage, String topPlaceTitle) {
        this.topPlaceImage = topPlaceImage;
        this.topPlaceTitle = topPlaceTitle;
    }

    public int getTopPlaceImage() {
        return topPlaceImage;
    }

    public void setTopPlaceImage(int topPlaceImage) {
        this.topPlaceImage = topPlaceImage;
    }

    public String getTopPlaceTitle() {
        return topPlaceTitle;
    }

    public void setTopPlaceTitle(String topPlaceTitle) {
        this.topPlaceTitle = topPlaceTitle;
    }
}
