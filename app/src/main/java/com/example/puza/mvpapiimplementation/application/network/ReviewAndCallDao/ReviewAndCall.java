package com.example.puza.mvpapiimplementation.application.network.ReviewAndCallDao;

public class ReviewAndCall {

    private int reviewPlaceImage;
    private int personImage;
    private int rateImage;
    private String reviewPlaceName;
    private String reviewPlaceDescription;
    private String reviewPersonName;
    private String reviewRateNumber;

    public ReviewAndCall(int reviewPlaceImage, int personImage, int rateImage, String reviewPlaceName, String reviewPlaceDescription, String reviewPersonName, String reviewRateNumber) {
        this.reviewPlaceImage = reviewPlaceImage;
        this.personImage = personImage;
        this.rateImage = rateImage;
        this.reviewPlaceName = reviewPlaceName;
        this.reviewPlaceDescription = reviewPlaceDescription;
        this.reviewPersonName = reviewPersonName;
        this.reviewRateNumber = reviewRateNumber;
    }

    public int getReviewPlaceImage() {
        return reviewPlaceImage;
    }

    public void setReviewPlaceImage(int reviewPlaceImage) {
        this.reviewPlaceImage = reviewPlaceImage;
    }

    public int getPersonImage() {
        return personImage;
    }

    public void setPersonImage(int personImage) {
        this.personImage = personImage;
    }

    public int getRateImage() {
        return rateImage;
    }

    public void setRateImage(int rateImage) {
        this.rateImage = rateImage;
    }

    public String getReviewPlaceName() {
        return reviewPlaceName;
    }

    public void setReviewPlaceName(String reviewPlaceName) {
        this.reviewPlaceName = reviewPlaceName;
    }

    public String getReviewPlaceDescription() {
        return reviewPlaceDescription;
    }

    public void setReviewPlaceDescription(String reviewPlaceDescription) {
        this.reviewPlaceDescription = reviewPlaceDescription;
    }

    public String getReviewPersonName() {
        return reviewPersonName;
    }

    public void setReviewPersonName(String reviewPersonName) {
        this.reviewPersonName = reviewPersonName;
    }

    public String getReviewRateNumber() {
        return reviewRateNumber;
    }

    public void setReviewRateNumber(String reviewRateNumber) {
        this.reviewRateNumber = reviewRateNumber;
    }
}
