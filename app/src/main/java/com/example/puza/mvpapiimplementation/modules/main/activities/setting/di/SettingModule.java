package com.example.puza.mvpapiimplementation.modules.main.activities.setting.di;

import android.support.v7.app.AppCompatActivity;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.example.puza.mvpapiimplementation.modules.main.activities.setting.mvp.SettingModel;
import com.example.puza.mvpapiimplementation.modules.main.activities.setting.mvp.SettingPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.setting.mvp.SettingView;

import dagger.Module;
import dagger.Provides;

@Module
public class SettingModule {

    public  final AppCompatActivity activity;

    public SettingModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @SettingScope
    SettingView popularPlacesListView() {
        return new SettingView(activity);
    }

    @Provides
    @SettingScope
    SettingPresenter settingPresenter(SchedulerProvider schedulerProvider, SettingView settingView, SettingModel settingModel){
        return  new SettingPresenter(activity,schedulerProvider,settingView,settingModel);
    }

    @Provides
    @SettingScope
    SettingModel popularPlacesListInteracter(PreferencesManager preferencesManager, AppNetwork appNetwork){
        return new SettingModel(preferencesManager,appNetwork);
    }

}
