package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.todoFragment.mvp;

import android.support.v7.app.AppCompatActivity;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;

public class ToDoModel {
    AppCompatActivity activity;
    PreferencesManager preferencesManager;
    AppNetwork appNetwork;

    public ToDoModel(AppCompatActivity activity, PreferencesManager preferencesManager, AppNetwork appNetwork) {
        this.activity = activity;
        this.preferencesManager = preferencesManager;
        this.appNetwork = appNetwork;
    }
}
