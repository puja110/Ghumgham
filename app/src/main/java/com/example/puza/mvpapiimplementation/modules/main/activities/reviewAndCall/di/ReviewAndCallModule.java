package com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.di;

import android.support.v7.app.AppCompatActivity;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.mvp.ReviewAndCallModel;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.mvp.ReviewAndCallPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.mvp.ReviewAndCallView;

import dagger.Module;
import dagger.Provides;

@Module
public class ReviewAndCallModule {

    public  final AppCompatActivity activity;

    public ReviewAndCallModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ReviewAndCallScope
    ReviewAndCallView reviewAndCallView() {
        return new ReviewAndCallView(activity);
    }

    @Provides
    @ReviewAndCallScope
    ReviewAndCallPresenter reviewAndCallPresenter(SchedulerProvider schedulerProvider, ReviewAndCallView reviewAndCallView, ReviewAndCallModel reviewAndCallModel){
        return  new ReviewAndCallPresenter(activity,schedulerProvider,reviewAndCallView,reviewAndCallModel);
    }

    @Provides
    @ReviewAndCallScope
    ReviewAndCallModel reviewAndCallModel(PreferencesManager preferencesManager, AppNetwork appNetwork){
        return new ReviewAndCallModel(preferencesManager,appNetwork);
    }
}
