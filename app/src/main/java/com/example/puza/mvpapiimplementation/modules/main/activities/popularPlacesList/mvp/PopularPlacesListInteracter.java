package com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.mvp;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;
import com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.placeListDao.PlaceList;

import io.reactivex.Observable;

public class PopularPlacesListInteracter {

    PreferencesManager preferencesManager;
    AppNetwork appNetwork;

    public PopularPlacesListInteracter(PreferencesManager preferencesManager, AppNetwork appNetwork) {
        this.preferencesManager = preferencesManager;
        this.appNetwork = appNetwork;
    }

    /*get the place list */
    public Observable<PlaceList> getPlaceList() {
        return appNetwork.getPlaceList();
    }
}
