package com.example.puza.mvpapiimplementation.modules.main.activities.placeListDetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.puza.mvpapiimplementation.application.di.MainApplication;
import com.example.puza.mvpapiimplementation.modules.main.activities.placeListDetail.di.DaggerPlaceDetailComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.placeListDetail.di.PlaceDetailModule;
import com.example.puza.mvpapiimplementation.modules.main.activities.placeListDetail.mvp.PlaceDetailPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.placeListDetail.mvp.PlaceDetailView;

import javax.inject.Inject;

public class PlaceDetailsActivity extends AppCompatActivity {

    @Inject
    PlaceDetailPresenter placeDetailPresenter;

    @Inject
    PlaceDetailView placeDetailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerPlaceDetailComponent.builder().applicationComponent(MainApplication.get(this).getApplicationComponent()).placeDetailModule(new PlaceDetailModule(this)).build().inject(this);
        setContentView(placeDetailView);
        placeDetailPresenter.onViewCreated();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        placeDetailPresenter.onDestroy();
    }
}
