package com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.mvp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.puza.mvpapiimplementation.application.network.placeReviewsDao.PlaceReviews;
import com.example.puza.mvpapiimplementation.helper.Constants;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.example.puza.mvpapiimplementation.helper.Utils;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.WriteReviewActivity;
import com.google.gson.Gson;

import io.reactivex.disposables.CompositeDisposable;

public class ReviewAndCallPresenter {

    AppCompatActivity activity;
    SchedulerProvider schedulerProvider;
    ReviewAndCallView reviewAndCallView;
    ReviewAndCallModel reviewAndCallModel;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    String id = "";

    public ReviewAndCallPresenter(AppCompatActivity activity, SchedulerProvider schedulerProvider, ReviewAndCallView reviewAndCallView, ReviewAndCallModel reviewAndCallModel) {
        this.activity = activity;
        this.schedulerProvider = schedulerProvider;
        this.reviewAndCallView = reviewAndCallView;
        this.reviewAndCallModel = reviewAndCallModel;
    }

    public void onViewCreated() {

        reviewAndCallView.writeReview.setOnClickListener(v -> {
            Intent intent = new Intent(activity, WriteReviewActivity.class);
            intent.putExtra("message",String.valueOf(id));
            activity.startActivity(intent);
        });

        if (activity.getIntent()!= null){

            Log.e("placeReview",(activity.getIntent().getStringExtra("message")));

            id = activity.getIntent().getStringExtra("message");
        }

        reviewAndCallView.swipeRefreshLayout.setOnRefreshListener(() -> {

            if (Utils.isNetworkAvailable(activity.getApplicationContext())) {
                onApicalReview();
                reviewAndCallView.swipeRefreshLayout.setRefreshing(false);
            }
            else {
                Toast.makeText(activity, "No Network Connection", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void onApicalReview() {

        compositeDisposable.add(reviewAndCallModel.getPlaceReviews(prepareUrl())
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(this::onSuccessPlaceReview,this::onerror));

    }

    private void onSuccessPlaceReview(PlaceReviews placeReviews) {

        if (placeReviews.getData() != null)
        {
            Toast.makeText(activity, "Not null", Toast.LENGTH_SHORT).show();

            reviewAndCallView.setPlaceReviewAdapter(placeReviews.getData());

        } else {
            Toast.makeText(activity, "Data not found", Toast.LENGTH_SHORT).show();
        }
    }

    private String prepareUrl() {

        Log.e("reviews",Constants.BASE_URL.concat(id));
        return Constants.BASE_URL.concat("products/").concat(id).concat("/reviews");
    }

    private void onerror(Throwable throwable) {

        Log.e("error", new Gson().toJson(throwable));
        Toast.makeText(activity, throwable.getMessage(), Toast.LENGTH_LONG).show();
    }
    public void onDestroy() {
        compositeDisposable.clear();
    }

}
