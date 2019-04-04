package com.example.puza.mvpapiimplementation.application.network.PopularPlacesDao;

public class PopularPlaces {

    private int popularPlaceImage;
    private String popularPlaceName;
    private String popularPlaceDescription;

    public PopularPlaces(int popularPlaceImage, String popularPlaceName, String popularPlaceDescription) {
        this.popularPlaceImage = popularPlaceImage;
        this.popularPlaceName = popularPlaceName;
        this.popularPlaceDescription = popularPlaceDescription;
    }

    public int getPopularPlaceImage() {
        return popularPlaceImage;
    }

    public void setPopularPlaceImage(int popularPlaceImage) {
        this.popularPlaceImage = popularPlaceImage;
    }

    public String getPopularPlaceName() {
        return popularPlaceName;
    }

    public void setPopularPlaceName(String popularPlaceName) {
        this.popularPlaceName = popularPlaceName;
    }

    public String getPopularPlaceDescription() {
        return popularPlaceDescription;
    }

    public void setPopularPlaceDescription(String popularPlaceDescription) {
        this.popularPlaceDescription = popularPlaceDescription;
    }
}
