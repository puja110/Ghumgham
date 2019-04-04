package com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.di;

import android.support.v7.app.AppCompatActivity;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.example.puza.mvpapiimplementation.modules.main.adapter.PopularPlacesListAdapter;
import com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.mvp.PopularPlacesListInteracter;
import com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.mvp.PopularPlacesListPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.mvp.PopularPlacesListView;
import dagger.Module;
import dagger.Provides;

@Module
public class PopularPlacesListModule {

    public  final AppCompatActivity activity;

    public PopularPlacesListModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PopularPlacesListScope
    PopularPlacesListView popularPlacesListView(PopularPlacesListAdapter popularPlacesListAdapter) {
        return new PopularPlacesListView(activity, popularPlacesListAdapter);
    }

    @Provides
    @PopularPlacesListScope
    PopularPlacesListPresenter popularPlacesListPresenter(SchedulerProvider schedulerProvider, PopularPlacesListView popularPlacesListView, PopularPlacesListInteracter popularPlacesListInteracter){
        return  new PopularPlacesListPresenter(activity,schedulerProvider,popularPlacesListView,popularPlacesListInteracter);
    }

    @Provides
    @PopularPlacesListScope
    PopularPlacesListInteracter popularPlacesListInteracter(PreferencesManager preferencesManager, AppNetwork appNetwork){
        return new PopularPlacesListInteracter(preferencesManager,appNetwork);
    }

    @PopularPlacesListScope
    @Provides
    public PopularPlacesListAdapter popularPlacesListAdapter() {
        return new PopularPlacesListAdapter(activity);
    }
}
