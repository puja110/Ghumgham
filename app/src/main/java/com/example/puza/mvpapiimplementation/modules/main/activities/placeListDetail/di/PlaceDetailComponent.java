package com.example.puza.mvpapiimplementation.modules.main.activities.placeListDetail.di;

import com.example.puza.mvpapiimplementation.application.di.ApplicationComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.placeListDetail.PlaceDetailsActivity;

import dagger.Component;

@PlaceDetailScope
@Component(modules = PlaceDetailModule.class, dependencies = ApplicationComponent.class)
public interface PlaceDetailComponent {

    void inject(PlaceDetailsActivity placeDetailsActivity);
}
