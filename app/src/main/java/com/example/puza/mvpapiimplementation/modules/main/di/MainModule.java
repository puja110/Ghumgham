package com.example.puza.mvpapiimplementation.modules.main.di;

import android.support.v7.app.AppCompatActivity;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.example.puza.mvpapiimplementation.modules.main.mvp.MainInteractor;
import com.example.puza.mvpapiimplementation.modules.main.mvp.MainPresenter;
import com.example.puza.mvpapiimplementation.modules.main.mvp.MainView;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    public  final AppCompatActivity activity;

    public MainModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @MainScope
    MainView provideMainView() {
        return new MainView(activity);
    }

    @Provides
    @MainScope
    MainPresenter provieMainPresenter(SchedulerProvider schedulerProvider, MainView mainView, MainInteractor mainInteractor){
        return  new MainPresenter(activity,schedulerProvider,mainView,mainInteractor);
    }

    @Provides
    @MainScope
    MainInteractor  mainInteractor(PreferencesManager preferencesManager, AppNetwork appNetwork){
        return new MainInteractor(preferencesManager,appNetwork);
    }
}
