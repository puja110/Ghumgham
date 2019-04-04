package com.example.puza.mvpapiimplementation.modules.main.fragment.home.mvp;

import android.support.v7.app.AppCompatActivity;

import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.application.network.RecentDao.RecentProducts;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;

import io.reactivex.Observable;

public class HomeModel {

    private final AppNetwork appNetwork;
    private AppCompatActivity activity;
    private final PreferencesManager preferencesManager;

    public HomeModel(AppCompatActivity activity, AppNetwork appNetwork, PreferencesManager preferencesManager) {
        this.appNetwork =  appNetwork;
        this.activity = activity;
        this.preferencesManager = preferencesManager;
    }

//    /*get the Recent list */
//    public Observable<RecentProducts> getRecentProducts() {
//        return appNetwork.getRecentProducts(activity.getResources().getString(R.string.securitykey));
//    }
}
