package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.mvp;

import android.support.v7.app.AppCompatActivity;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;

public class CategoryGridModel {

    AppCompatActivity activity;
    PreferencesManager preferencesManager;
    AppNetwork appNetwork;

    public CategoryGridModel(AppCompatActivity activity, PreferencesManager preferencesManager, AppNetwork appNetwork) {
        this.activity = activity;
        this.preferencesManager = preferencesManager;
        this.appNetwork = appNetwork;
    }

}
