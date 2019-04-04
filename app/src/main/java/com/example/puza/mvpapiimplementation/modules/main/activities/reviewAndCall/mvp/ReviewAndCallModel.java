package com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.mvp;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.application.network.placeReviewsDao.PlaceReviews;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;

import io.reactivex.Observable;

public class ReviewAndCallModel {

    PreferencesManager preferencesManager;
    AppNetwork appNetwork;

    public ReviewAndCallModel(PreferencesManager preferencesManager, AppNetwork appNetwork) {
        this.preferencesManager = preferencesManager;
        this.appNetwork = appNetwork;
    }

    /*get the place review */
    public Observable<PlaceReviews> getPlaceReviews(String url) {
        return appNetwork.getPlaceReviews(url);
    }
}
