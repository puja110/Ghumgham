package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment.mvp;

import android.support.v7.app.AppCompatActivity;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;

public class ToEatModel {

    AppCompatActivity activity;
    PreferencesManager preferencesManager;
    AppNetwork appNetwork;

    public ToEatModel(AppCompatActivity activity, PreferencesManager preferencesManager, AppNetwork appNetwork) {
        this.activity = activity;
        this.preferencesManager = preferencesManager;
        this.appNetwork = appNetwork;
    }

}
