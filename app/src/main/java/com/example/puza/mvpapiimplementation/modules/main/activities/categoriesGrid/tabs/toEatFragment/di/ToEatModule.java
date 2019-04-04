package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment.di;

import android.support.v7.app.AppCompatActivity;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment.mvp.ToEatModel;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment.mvp.ToEatPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment.mvp.ToEatView;

import dagger.Module;
import dagger.Provides;

@Module
public class ToEatModule {

    AppCompatActivity activity;

    public ToEatModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ToEatScope
    ToEatView toEatView() {
        return new ToEatView(activity);
    }

    @Provides
    @ToEatScope
    ToEatPresenter toEatPresenter(SchedulerProvider schedulerProvider, ToEatView toEatView, ToEatModel toEatModel){
        return  new ToEatPresenter(activity,schedulerProvider,toEatView,toEatModel);
    }

    @Provides
    @ToEatScope
    ToEatModel toEatModel(PreferencesManager preferencesManager, AppNetwork appNetwork){
        return new ToEatModel(activity,preferencesManager,appNetwork);
    }
}
