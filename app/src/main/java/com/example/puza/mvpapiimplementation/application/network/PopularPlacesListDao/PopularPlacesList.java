package com.example.puza.mvpapiimplementation.application.network.PopularPlacesListDao;

public class PopularPlacesList {

    private int popularPlaceListImage;
    private String popularPlaceListName;
    private String popularPlaceListDescription;

    public PopularPlacesList(int popularPlaceListImage, String popularPlaceListName, String popularPlaceListDescription) {
        this.popularPlaceListImage = popularPlaceListImage;
        this.popularPlaceListName = popularPlaceListName;
        this.popularPlaceListDescription = popularPlaceListDescription;
    }

    public int getPopularPlaceListImage() {
        return popularPlaceListImage;
    }

    public void setPopularPlaceListImage(int popularPlaceListImage) {
        this.popularPlaceListImage = popularPlaceListImage;
    }

    public String getPopularPlaceListName() {
        return popularPlaceListName;
    }

    public void setPopularPlaceListName(String popularPlaceListName) {
        this.popularPlaceListName = popularPlaceListName;
    }

    public String getPopularPlaceListDescription() {
        return popularPlaceListDescription;
    }

    public void setPopularPlaceListDescription(String popularPlaceListDescription) {
        this.popularPlaceListDescription = popularPlaceListDescription;
    }
}
