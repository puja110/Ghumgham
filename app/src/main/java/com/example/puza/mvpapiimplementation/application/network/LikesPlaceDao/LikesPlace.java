package com.example.puza.mvpapiimplementation.application.network.LikesPlaceDao;

public class LikesPlace {

    private int likesPlaceImage;
    private String likesPlaceTitle;

    public LikesPlace(int likesPlaceImage, String likesPlaceTitle) {
        this.likesPlaceImage = likesPlaceImage;
        this.likesPlaceTitle = likesPlaceTitle;
    }

    public int getLikesPlaceImage() {
        return likesPlaceImage;
    }

    public void setLikesPlaceImage(int likesPlaceImage) {
        this.likesPlaceImage = likesPlaceImage;
    }


    public String getLikesPlaceTitle() {
        return likesPlaceTitle;
    }

    public void setLikesPlaceTitle(String likesPlaceTitle) {
        this.likesPlaceTitle = likesPlaceTitle;
    }
}
