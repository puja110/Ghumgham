package com.example.puza.mvpapiimplementation.modules.main.fragment.home.di;

import android.support.v7.app.AppCompatActivity;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.example.puza.mvpapiimplementation.modules.main.fragment.home.mvp.HomeModel;
import com.example.puza.mvpapiimplementation.modules.main.fragment.home.mvp.HomePresenter;
import com.example.puza.mvpapiimplementation.modules.main.fragment.home.mvp.HomeView;
import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    private final AppCompatActivity activity;

    public HomeModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @HomeScope
    @Provides
    public HomeView homeView() {
        return new HomeView(activity);
    }

    @HomeScope
    @Provides
    public HomeModel homeModel(AppNetwork appNetwork, PreferencesManager preferencesManager) {
        return new HomeModel(activity, appNetwork, preferencesManager);
    }

    @HomeScope
    @Provides
    public HomePresenter homePresenter(HomeView homeView, HomeModel homeModel, SchedulerProvider schedulerProvider) {
        return new HomePresenter(activity,homeView, homeModel,schedulerProvider);
    }

//    @HomeScope
//    @Provides
//    public RecentRecycler recentRecycler() {
//        return new RecentRecycler(activity);
//    }

}
