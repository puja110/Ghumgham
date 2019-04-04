package com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.activity.mvp;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;

public class UserReviewModel {

    PreferencesManager preferencesManager;
    AppNetwork appNetwork;

    public UserReviewModel(PreferencesManager preferencesManager, AppNetwork appNetwork) {
        this.preferencesManager = preferencesManager;
        this.appNetwork = appNetwork;
    }
}
