package com.example.puza.mvpapiimplementation.modules.main.activities.profile.mvp;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;

public class ProfileModel {

    PreferencesManager preferencesManager;
    AppNetwork appNetwork;

    public ProfileModel(PreferencesManager preferencesManager, AppNetwork appNetwork) {
        this.preferencesManager = preferencesManager;
        this.appNetwork = appNetwork;
    }
}
