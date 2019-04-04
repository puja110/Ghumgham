package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toSleepFragment.di;

import android.support.v7.app.AppCompatActivity;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toSleepFragment.mvp.ToSleepModel;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toSleepFragment.mvp.ToSleepPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toSleepFragment.mvp.ToSleepView;

import dagger.Module;
import dagger.Provides;

@Module
public class ToSleepModule {

    AppCompatActivity activity;

    public ToSleepModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ToSleepScope
    ToSleepView toSleepView() {
        return new ToSleepView(activity);
    }

    @Provides
    @ToSleepScope
    ToSleepPresenter toSleepPresenter(SchedulerProvider schedulerProvider, ToSleepView toSleepView, ToSleepModel toSleepModel){
        return  new ToSleepPresenter(activity,schedulerProvider,toSleepView,toSleepModel);
    }

    @Provides
    @ToSleepScope
    ToSleepModel toSleepModel(PreferencesManager preferencesManager, AppNetwork appNetwork){
        return new ToSleepModel(activity,preferencesManager,appNetwork);
    }
}
