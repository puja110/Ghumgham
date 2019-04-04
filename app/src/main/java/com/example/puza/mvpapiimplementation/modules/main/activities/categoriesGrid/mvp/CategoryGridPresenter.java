package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.mvp;

import android.support.v7.app.AppCompatActivity;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class CategoryGridPresenter {

    AppCompatActivity activity;
    SchedulerProvider schedulerProvider;
    CategoryGridView categoryGridView;
    CategoryGridModel categoryGridModel;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public CategoryGridPresenter(AppCompatActivity activity, SchedulerProvider schedulerProvider, CategoryGridView categoryGridView, CategoryGridModel categoryGridModel) {
        this.activity = activity;
        this.schedulerProvider = schedulerProvider;
        this.categoryGridView = categoryGridView;
        this.categoryGridModel = categoryGridModel;
    }

    public void onViewCreated() {

    }

    public void onDestroy() {
        compositeDisposable.clear();
    }
}
