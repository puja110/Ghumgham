package com.example.puza.mvpapiimplementation.modules.main.activities.placeListDetail.di;

import android.support.v7.app.AppCompatActivity;
import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.example.puza.mvpapiimplementation.modules.main.activities.placeListDetail.mvp.PlaceDetailModel;
import com.example.puza.mvpapiimplementation.modules.main.activities.placeListDetail.mvp.PlaceDetailPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.placeListDetail.mvp.PlaceDetailView;

import dagger.Module;
import dagger.Provides;

@Module
public class PlaceDetailModule {

    public  final AppCompatActivity activity;

    public PlaceDetailModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PlaceDetailScope
    PlaceDetailView placeDetailView() {
        return new PlaceDetailView(activity);
    }

    @Provides
    @PlaceDetailScope
    PlaceDetailPresenter placeDetailPresenter(SchedulerProvider schedulerProvider, PlaceDetailView placeDetailView, PlaceDetailModel placeDetailModel){
        return  new PlaceDetailPresenter(activity,schedulerProvider,placeDetailView,placeDetailModel);
    }

    @Provides
    @PlaceDetailScope
    PlaceDetailModel placeDetailModel(PreferencesManager preferencesManager, AppNetwork appNetwork){
        return new PlaceDetailModel(activity, preferencesManager,appNetwork);
    }
}
