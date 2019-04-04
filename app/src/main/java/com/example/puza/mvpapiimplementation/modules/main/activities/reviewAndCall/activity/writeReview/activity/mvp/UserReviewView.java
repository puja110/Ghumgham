package com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.activity.mvp;

import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.puza.mvpapiimplementation.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserReviewView extends FrameLayout {

    AppCompatActivity activity;

    @BindView(R.id.reviewPersonName)
    TextView reviewPersonName;

    @BindView(R.id.reviewDescription)
    TextView reviewDescription;

    public UserReviewView(AppCompatActivity activity) {
        super(activity);
        this.activity = activity;
        inflate(activity, R.layout.activity_user_review, this);
        ButterKnife.bind(this);
    }
}
