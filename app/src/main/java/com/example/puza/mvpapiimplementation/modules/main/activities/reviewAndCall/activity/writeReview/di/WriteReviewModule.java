package com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.di;

import android.support.v7.app.AppCompatActivity;
import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.mvp.WriteReviewModel;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.mvp.WriteReviewPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.mvp.WriteReviewView;

import dagger.Module;
import dagger.Provides;

@Module
public class WriteReviewModule {

    public  final AppCompatActivity activity;

    public WriteReviewModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @WriteReviewScope
    WriteReviewView writeReviewView() {
        return new WriteReviewView(activity);
    }

    @Provides
    @WriteReviewScope
    WriteReviewPresenter writeReviewPresenter(SchedulerProvider schedulerProvider, WriteReviewView writeReviewView, WriteReviewModel writeReviewModel){
        return  new WriteReviewPresenter(activity,schedulerProvider,writeReviewView,writeReviewModel);
    }

    @Provides
    @WriteReviewScope
    WriteReviewModel writeReviewModel(PreferencesManager preferencesManager, AppNetwork appNetwork){
        return new WriteReviewModel(preferencesManager,appNetwork);
    }

}
