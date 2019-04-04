package com.example.puza.mvpapiimplementation.modules.main.activities.placeListDetail.mvp;

import android.support.v7.app.AppCompatActivity;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.application.network.placeDetailDao.PlaceDetail;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;

import io.reactivex.Observable;

public class PlaceDetailModel {

    private AppCompatActivity activity;

    PreferencesManager preferencesManager;
    AppNetwork appNetwork;

    public PlaceDetailModel(AppCompatActivity activity, PreferencesManager preferencesManager, AppNetwork appNetwork) {
        this.activity = activity;
        this.preferencesManager = preferencesManager;
        this.appNetwork = appNetwork;
    }

    /*get the place details */
    public Observable<PlaceDetail> getPlacedescription(String url) {
        return appNetwork.getPlacedescription(url);
    }
}
