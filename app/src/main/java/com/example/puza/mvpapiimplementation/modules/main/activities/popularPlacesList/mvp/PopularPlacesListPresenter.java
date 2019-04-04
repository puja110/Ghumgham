package com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.mvp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.example.puza.mvpapiimplementation.helper.Utils;
import com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.placeListDao.Datum;
import com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.placeListDao.PlaceList;

import com.google.gson.Gson;

import io.reactivex.disposables.CompositeDisposable;

public class PopularPlacesListPresenter {

    AppCompatActivity activity;
    SchedulerProvider schedulerProvider;

    PopularPlacesListView popularPlacesListView;
    PopularPlacesListInteracter popularPlacesListInteracter;

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public PopularPlacesListPresenter(AppCompatActivity activity, SchedulerProvider schedulerProvider, PopularPlacesListView popularPlacesListView, PopularPlacesListInteracter popularPlacesListInteracter) {
        this.activity = activity;
        this.schedulerProvider = schedulerProvider;
        this.popularPlacesListView = popularPlacesListView;
        this.popularPlacesListInteracter = popularPlacesListInteracter;
    }

    public void onViewCreated() {

        popularPlacesListView.swipeRefreshLayout.setOnRefreshListener(() -> {

            if (Utils.isNetworkAvailable(activity.getApplicationContext())) {
                apiCallPlaceList();
                popularPlacesListView.swipeRefreshLayout.setRefreshing(false);
            }
            else {
                Toast.makeText(activity, "No Network Connection", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void apiCallPlaceList() {
        compositeDisposable.add(popularPlacesListInteracter.getPlaceList()
        .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
        .subscribe(this::onSuccessPlaceList,this::onerror));

    }

    private void onerror(Throwable throwable) {

        Log.e("error", new Gson().toJson(throwable));

        Toast.makeText(activity, throwable.getMessage(), Toast.LENGTH_LONG).show();
    }

    private  void onSuccessPlaceList(PlaceList placeList){

        Log.d("datafound", placeList+"");

        if (placeList.getData() != null)
        {
            popularPlacesListView.setPlaceListAdapter(placeList.getData());

        } else {

            Toast.makeText(activity, "Data not found", Toast.LENGTH_SHORT).show();
        }
    }

    public class SaveIntoDatabase extends AsyncTask<Datum, Datum, Boolean> {

        private final String TAG = SaveIntoDatabase.class.getSimpleName();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Datum... params) {
            return null;
        }

        @Override
        protected void onProgressUpdate(Datum... values) {
            super.onProgressUpdate(values);

        }
    }

    public void onDestroy() {
        compositeDisposable.clear();
    }
}
