package com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.placeListDao;

public class PlaceListModel {

    private String name;
    private String rating;

    public PlaceListModel(String name, String rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
