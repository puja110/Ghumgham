package com.example.puza.mvpapiimplementation.application.network.FavoritePlaceDao;

public class FavoritePlace {

    private int favPlaceImage;
    private String favPlaceTitle;

    public FavoritePlace(int favPlaceImage, String favPlaceTitle) {
        this.favPlaceImage = favPlaceImage;
        this.favPlaceTitle = favPlaceTitle;
    }

    public int getFavPlaceImage() {
        return favPlaceImage;
    }

    public void setFavPlaceImage(int favPlaceImage) {
        this.favPlaceImage = favPlaceImage;
    }

    public String getFavPlaceTitle() {
        return favPlaceTitle;
    }

    public void setFavPlaceTitle(String favPlaceTitle) {
        this.favPlaceTitle = favPlaceTitle;
    }
}
