package com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.activity.di;
import android.support.v7.app.AppCompatActivity;
import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.activity.mvp.UserReviewModel;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.activity.mvp.UserReviewPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.activity.mvp.UserReviewView;
import dagger.Module;
import dagger.Provides;

@Module
public class UserReviewModule {

    AppCompatActivity activity;

    public UserReviewModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @UserReviewScope
    UserReviewView userReviewView(){
        return new UserReviewView(activity);
    }

    @Provides
    @UserReviewScope
    UserReviewPresenter userReviewPresenter(SchedulerProvider schedulerProvider, UserReviewView userReviewView, UserReviewModel userReviewModel){
        return  new UserReviewPresenter(activity,schedulerProvider,userReviewView,userReviewModel);
    }

    @Provides
    @UserReviewScope
    UserReviewModel userReviewModel(PreferencesManager preferencesManager, AppNetwork appNetwork){
        return new UserReviewModel(preferencesManager,appNetwork);
    }
}
