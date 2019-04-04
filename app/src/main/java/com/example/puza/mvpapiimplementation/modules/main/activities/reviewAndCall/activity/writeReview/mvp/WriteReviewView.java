package com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.mvp;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.puza.mvpapiimplementation.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WriteReviewView extends FrameLayout {

    AppCompatActivity activity;

    @BindView(R.id.customer)
    TextView customer;

    @BindView(R.id.body)
    EditText body;

    @BindView(R.id.rating)
    RatingBar star;

    @BindView(R.id.postReview)
    Button postReview;

    public WriteReviewView(AppCompatActivity activity) {
        super(activity);
        this.activity = activity;
        inflate(activity, R.layout.activity_write_review, this);

        ButterKnife.bind(this);

    }

}
