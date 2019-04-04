package com.example.puza.mvpapiimplementation.modules.main.mvp;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;

public class MainInteractor {

    PreferencesManager preferencesManager;
    AppNetwork appNetwork;

    public MainInteractor(PreferencesManager preferencesManager, AppNetwork appNetwork) {
        this.preferencesManager = preferencesManager;
        this.appNetwork = appNetwork;
    }
}
