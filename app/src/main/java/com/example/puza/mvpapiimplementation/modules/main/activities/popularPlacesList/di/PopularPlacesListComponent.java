package com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.di;

import com.example.puza.mvpapiimplementation.application.di.ApplicationComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.PopularPlacesListActivity;

import dagger.Component;

@PopularPlacesListScope
@Component(modules = PopularPlacesListModule.class,dependencies = ApplicationComponent.class)
public interface PopularPlacesListComponent {
    void inject(PopularPlacesListActivity popularPlacesListActivity);
}

