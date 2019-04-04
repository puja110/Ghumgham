package com.example.puza.mvpapiimplementation.modules.main.activities.placeListDetail.mvp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.puza.mvpapiimplementation.application.network.placeDetailDao.PlaceDetail;
import com.example.puza.mvpapiimplementation.helper.Constants;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.example.puza.mvpapiimplementation.helper.Utils;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.ReviewAndCallActivity;
import com.google.gson.Gson;

import io.reactivex.disposables.CompositeDisposable;

public class PlaceDetailPresenter {

    AppCompatActivity activity;
    SchedulerProvider schedulerProvider;

    PlaceDetailView placeDetailView;
    PlaceDetailModel placeDetailModel;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    String id = "";
    ProgressDialog progressDialog;

//    ArrayList<Data> detailList;
//    detailList = new ArrayList<> (Arrays.asList((Assessment[])oStream.readObject()));
//    public List<Data> detailList;
//    ObjectInputStream oStream;

    public PlaceDetailPresenter(AppCompatActivity activity, SchedulerProvider schedulerProvider, PlaceDetailView placeDetailView, PlaceDetailModel placeDetailModel) {
        this.activity = activity;
        this.schedulerProvider = schedulerProvider;
        this.placeDetailView = placeDetailView;
        this.placeDetailModel = placeDetailModel;
    }

    public void onViewCreated(){

        if (activity.getIntent()!= null){

            Log.e("sfdfgsf",(activity.getIntent().getStringExtra("message")));

            id = activity.getIntent().getStringExtra("message");
            if (Utils.isNetworkAvailable(activity.getApplicationContext())) {
                onAPicalDetail();
            }
            else
                {
            }

            placeDetailView.reviewBtn.setOnClickListener(v -> {

                Log.e("detailToReview", String.valueOf(id));

                Intent intent = new Intent(activity, ReviewAndCallActivity.class);
                intent.putExtra("message",String.valueOf(id));
                activity.startActivity(intent);
            });
        }
    }

    private void onAPicalDetail() {
        compositeDisposable.add(placeDetailModel.getPlacedescription(prepareUrl())
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(this::onSuccessPlaceList,this::onerror));
    }

    private void onSuccessPlaceList(PlaceDetail placeDetail) {

        placeDetailView.lay.setVisibility(View.VISIBLE);
        placeDetailView.progressBar.setVisibility(View.GONE);

        if (placeDetail.getData() != null)
        {

            Toast.makeText(activity, "Not null", Toast.LENGTH_SHORT).show();

            placeDetailView.placeListName.setText(placeDetail.getData().getName());
            placeDetailView.placeListdescription.setText(placeDetail.getData().getDescription());

        } else {
            Toast.makeText(activity, "Data not found", Toast.LENGTH_SHORT).show();
        }
    }

    private String prepareUrl() {
        Log.e("hey",Constants.BASE_URL.concat(id));
        return Constants.BASE_URL.concat("products/").concat(id);
    }

    private void onerror(Throwable throwable) {

        Log.e("error", new Gson().toJson(throwable));
        Toast.makeText(activity, throwable.getMessage(), Toast.LENGTH_LONG).show();
    }


    public void onDestroy() {
        compositeDisposable.clear();
    }

}
