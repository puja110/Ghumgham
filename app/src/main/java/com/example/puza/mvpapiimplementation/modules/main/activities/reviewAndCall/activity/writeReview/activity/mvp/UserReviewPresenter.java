package com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.activity.mvp;

import android.support.v7.app.AppCompatActivity;

import com.example.puza.mvpapiimplementation.application.network.placeReviewsDao.Datum;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class UserReviewPresenter {

    AppCompatActivity activity;
    SchedulerProvider schedulerProvider;
    UserReviewView userReviewView;
    UserReviewModel userReviewModel;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    Datum datum;

    public UserReviewPresenter(AppCompatActivity activity, SchedulerProvider schedulerProvider, UserReviewView userReviewView, UserReviewModel userReviewModel) {
        this.activity = activity;
        this.schedulerProvider = schedulerProvider;
        this.userReviewView = userReviewView;
        this.userReviewModel = userReviewModel;
    }

    public void onViewCreated() {

        if (activity.getIntent()!= null){

            datum = (Datum) activity.getIntent().getSerializableExtra("message");
        }

        userReviewView.reviewPersonName.setText(datum.getCustomer());
        userReviewView.reviewDescription.setText(datum.getBody());

    }

    public void onDestroy() {
        compositeDisposable.clear();
    }

}
