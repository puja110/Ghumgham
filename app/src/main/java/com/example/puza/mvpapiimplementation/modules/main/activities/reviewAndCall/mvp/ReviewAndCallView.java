package com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.mvp;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.application.network.placeReviewsDao.Datum;
import com.example.puza.mvpapiimplementation.modules.main.adapter.ReviewAdapter;
import com.google.gson.Gson;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewAndCallView extends FrameLayout {

    AppCompatActivity activity;

    @BindView(R.id.writeReview)
    TextView writeReview;

    public SwipeRefreshLayout swipeRefreshLayout;
    private TextView toolbarTitleGrid;

    ReviewAdapter reviewAndCallAdapter;
    RecyclerView rcRecyclerView;


    public ReviewAndCallView(AppCompatActivity activity) {
        super(activity);
        this.activity = activity;
        inflate(activity, R.layout.activity_review_and_call, this);
        ButterKnife.bind(this);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshReviews);

        /*------------------Review and Call Items--------------------------*/
        reviewAndCallAdapter = new ReviewAdapter(activity);

        rcRecyclerView = (RecyclerView)getRootView().findViewById(R.id.reviewAndCallRecyclerView);

        rcRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity,
                LinearLayoutManager.VERTICAL,
                false);
        rcRecyclerView.setLayoutManager(mLayoutManager);
        rcRecyclerView.setItemAnimator(new DefaultItemAnimator());

        rcRecyclerView.setAdapter(reviewAndCallAdapter);

        /*------------------------------------------------------------*/

        toolbarTitleGrid = (TextView)getRootView().findViewById(R.id.toolbarTitle);
        toolbarTitleGrid.setText("REVIEW AND CALL");
    }

    public void setPlaceReviewAdapter(List<Datum> data) {
        Log.e("placeReview",new Gson().toJson(data));
        reviewAndCallAdapter.showPlaceReview(data);

    }

}
