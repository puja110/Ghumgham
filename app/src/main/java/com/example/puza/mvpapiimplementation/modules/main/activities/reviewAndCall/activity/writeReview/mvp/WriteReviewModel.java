package com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.mvp;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.application.network.postReviewDao.ReviewResponse;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;

import io.reactivex.Observable;

public class WriteReviewModel {

    PreferencesManager preferencesManager;
    AppNetwork appNetwork;

    public WriteReviewModel(PreferencesManager preferencesManager, AppNetwork appNetwork) {
        this.preferencesManager = preferencesManager;
        this.appNetwork = appNetwork;
    }

    /*get the post review */
    public Observable<ReviewResponse> getPostReviews(String url, String customer, String body, Integer star) {
        return appNetwork.createPostReview(url,customer, body, star);
    }
}
