package com.example.puza.mvpapiimplementation.modules.main.activities.setting.mvp;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;

public class SettingModel {

    PreferencesManager preferencesManager;
    AppNetwork appNetwork;

    public SettingModel(PreferencesManager preferencesManager, AppNetwork appNetwork) {
        this.preferencesManager = preferencesManager;
        this.appNetwork = appNetwork;
    }

    /*get the place list */
//    public Observable<PlaceList> getPlaceList() {
//        return appNetwork.getPlaceList();
//    }

}
