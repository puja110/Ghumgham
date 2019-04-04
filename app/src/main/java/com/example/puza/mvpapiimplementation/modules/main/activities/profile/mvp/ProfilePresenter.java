package com.example.puza.mvpapiimplementation.modules.main.activities.profile.mvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.example.puza.mvpapiimplementation.modules.main.activities.profileEditor.ProfileEditorActivity;
import com.example.puza.mvpapiimplementation.modules.main.activities.setting.SettingActivity;

import io.reactivex.disposables.CompositeDisposable;

public class ProfilePresenter {

    AppCompatActivity activity;
    SchedulerProvider schedulerProvider;
    ProfileView profileView;
    ProfileModel profileModel;

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ProfilePresenter(AppCompatActivity activity, SchedulerProvider schedulerProvider, ProfileView profileView, ProfileModel profileModel) {
        this.activity = activity;
        this.schedulerProvider = schedulerProvider;
        this.profileView = profileView;
        this.profileModel = profileModel;
    }


    public void onViewCreated() {

        profileView.floatingActionButton.setOnClickListener(v -> {
            Intent i = new Intent(activity, ProfileEditorActivity.class);
            activity.startActivity(i);
        });

        profileView.settings.setOnClickListener(v -> {
            Intent i = new Intent(activity, SettingActivity.class);
            activity.startActivity(i);
        });

//        popularPlacesListView.swipeRefreshLayout.setOnRefreshListener(() -> {
//
//            if (Utils.isNetworkAvailable(activity.getApplicationContext())) {
//                apiCallPlaceList();
//                popularPlacesListView.swipeRefreshLayout.setRefreshing(false);
//            }
//            else {
//                Toast.makeText(activity, "No Network Connection", Toast.LENGTH_LONG).show();
//            }
//        });

    }

    public void onDestroy() {
        compositeDisposable.clear();
    }

//    private void apiCallFavorite() {
//        compositeDisposable.add(popularPlacesListInteracter.getPlaceList()
//                .subscribeOn(schedulerProvider.io())
//                .observeOn(schedulerProvider.ui())
//                .subscribe(this::onSuccessPlaceList,this::onerror));
//
//    }
//
//    private void onerror(Throwable throwable) {
//
//        Log.e("error", new Gson().toJson(throwable));
//        Toast.makeText(activity, throwable.getMessage(), Toast.LENGTH_LONG).show();
//    }
//
//    private  void onSuccessPlaceList(PlaceList placeList){
//
//        if (placeList.getData() != null)
//        {
//            popularPlacesListView.setPlaceListAdapter(placeList.getData());
//
//        } else {
//
////            popularPlacesListView.swipeRefreshLayout.setVisibility(View.VISIBLE);
//
//            Toast.makeText(activity, "Data not found", Toast.LENGTH_SHORT).show();
//        }
//    }

}
