package com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.puza.mvpapiimplementation.application.di.MainApplication;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.activity.di.DaggerUserReviewComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.activity.di.UserReviewModule;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.activity.mvp.UserReviewPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.activity.mvp.UserReviewView;

import javax.inject.Inject;

public class UserReviewActivity extends AppCompatActivity {

    @Inject
    UserReviewPresenter userReviewPresenter;

    @Inject
    UserReviewView userReviewView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerUserReviewComponent.builder().applicationComponent(MainApplication.get(this).getApplicationComponent()).userReviewModule(new UserReviewModule(this)).build().inject(this);
        setContentView(userReviewView);
        userReviewPresenter.onViewCreated();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userReviewPresenter.onDestroy();
    }
}
