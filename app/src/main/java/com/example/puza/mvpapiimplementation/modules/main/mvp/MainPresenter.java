package com.example.puza.mvpapiimplementation.modules.main.mvp;

import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter {

    AppCompatActivity activity;
    SchedulerProvider schedulerProvider;
    MainView mainView;
    MainInteractor mainInteractor;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MainPresenter(AppCompatActivity activity, SchedulerProvider schedulerProvider, MainView mainView, MainInteractor mainInteractor) {
        this.activity = activity;
        this.schedulerProvider = schedulerProvider;
        this.mainView = mainView;
        this.mainInteractor = mainInteractor;
    }

    public void onViewCreated() {

        mainView.navigationMenu.setOnClickListener(v -> mainView.drawer.openDrawer(GravityCompat.START));
    }

    public void onDestroy() {
        compositeDisposable.clear();
    }
}
