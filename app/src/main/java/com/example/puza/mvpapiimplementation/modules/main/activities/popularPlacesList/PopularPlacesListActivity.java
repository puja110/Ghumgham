package com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.puza.mvpapiimplementation.application.di.MainApplication;
import com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.di.DaggerPopularPlacesListComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.di.PopularPlacesListModule;
import com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.mvp.PopularPlacesListPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.mvp.PopularPlacesListView;
import javax.inject.Inject;

public class PopularPlacesListActivity extends AppCompatActivity {

    @Inject
    PopularPlacesListPresenter popularPlacesListPresenter;

    @Inject
    PopularPlacesListView popularPlacesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerPopularPlacesListComponent.builder().applicationComponent(MainApplication.get(this).getApplicationComponent()).popularPlacesListModule(new PopularPlacesListModule(this)).build().inject(this);
        setContentView(popularPlacesListView);
        popularPlacesListPresenter.onViewCreated();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        popularPlacesListPresenter.onDestroy();
    }
}
