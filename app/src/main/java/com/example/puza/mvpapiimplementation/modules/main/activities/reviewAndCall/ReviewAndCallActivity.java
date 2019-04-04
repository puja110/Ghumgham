package com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.puza.mvpapiimplementation.application.di.MainApplication;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.di.DaggerReviewAndCallComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.di.ReviewAndCallModule;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.mvp.ReviewAndCallPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.mvp.ReviewAndCallView;

import javax.inject.Inject;

public class ReviewAndCallActivity extends AppCompatActivity {

    @Inject
    ReviewAndCallPresenter reviewAndCallPresenter;

    @Inject
    ReviewAndCallView reviewAndCallView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerReviewAndCallComponent.builder().applicationComponent(MainApplication.get(this).getApplicationComponent()).reviewAndCallModule(new ReviewAndCallModule(this)).build().inject(this);
        setContentView(reviewAndCallView);
        reviewAndCallPresenter.onViewCreated();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        reviewAndCallPresenter.onDestroy();
    }
}
