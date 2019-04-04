package com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;

import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.application.di.MainApplication;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.di.DaggerWriteReviewComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.di.WriteReviewModule;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.mvp.WriteReviewPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.mvp.WriteReviewView;

import javax.inject.Inject;

public class WriteReviewActivity extends AppCompatActivity {

    private RatingBar ratingBar;

    @Inject
    WriteReviewPresenter writeReviewPresenter;

    @Inject
    WriteReviewView writeReviewView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerWriteReviewComponent.builder().applicationComponent(MainApplication.get(this).getApplicationComponent()).writeReviewModule(new WriteReviewModule(this)).build().inject(this);
        setContentView(writeReviewView);
        writeReviewPresenter.onViewCreated();

        ratingBar = (RatingBar)findViewById(R.id.rating);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        writeReviewPresenter.onDestroy();
    }
}
