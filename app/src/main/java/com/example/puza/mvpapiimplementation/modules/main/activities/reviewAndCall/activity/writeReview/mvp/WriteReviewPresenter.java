package com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.mvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.puza.mvpapiimplementation.application.network.postReviewDao.ReviewResponse;
import com.example.puza.mvpapiimplementation.helper.Constants;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.ReviewAndCallActivity;
import com.google.gson.Gson;

import io.reactivex.disposables.CompositeDisposable;

public class WriteReviewPresenter {

    AppCompatActivity activity;
    SchedulerProvider schedulerProvider;
    WriteReviewView writeReviewView;
    WriteReviewModel writeReviewModel;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    String id = "";

    public WriteReviewPresenter(AppCompatActivity activity, SchedulerProvider schedulerProvider, WriteReviewView writeReviewView, WriteReviewModel writeReviewModel) {
        this.activity = activity;
        this.schedulerProvider = schedulerProvider;
        this.writeReviewView = writeReviewView;
        this.writeReviewModel = writeReviewModel;
    }

    public void onViewCreated() {

        if (activity.getIntent()!= null){

            id = activity.getIntent().getStringExtra("message");

            Log.e("getidfromreviewandcall",(activity.getIntent().getStringExtra("message")));

        }

        writeReviewView.postReview.setOnClickListener(v -> {

            postReview();

            Intent intent = new Intent(activity, ReviewAndCallActivity.class);
            intent.putExtra("message",String.valueOf(id));
            activity.startActivity(intent);
        });
    }

    public void postReview() {

        compositeDisposable.add(writeReviewModel.getPostReviews(
                createURL(),

                writeReviewView.customer.getText().toString(),
                writeReviewView.body.getText().toString(),
                (int) writeReviewView.star.getRating())

                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(this::onSuccessPostReview,this::onError));
    }

    private void onSuccessPostReview(ReviewResponse reviewResponse) {

        Log.e("reviewResponse",new Gson().toJson(reviewResponse));

        if (reviewResponse.getStatus().equalsIgnoreCase("true")){

            Toast.makeText(activity, reviewResponse.getStatus(), Toast.LENGTH_SHORT).show();

        }else {

            Toast.makeText(activity,new Gson().toJson( reviewResponse.getMessage()), Toast.LENGTH_SHORT).show();

        }
    }

    private String createURL() {
        return  Constants.BASE_URL.concat("products/".concat(id).concat("/reviews"));
    }

    private void onError(Throwable throwable) {

        Log.e("errorMsgg",throwable.getMessage());
        Toast.makeText(activity, throwable.getMessage(), Toast.LENGTH_LONG).show();
    }

    public void onDestroy() {
        compositeDisposable.clear();
    }
}
