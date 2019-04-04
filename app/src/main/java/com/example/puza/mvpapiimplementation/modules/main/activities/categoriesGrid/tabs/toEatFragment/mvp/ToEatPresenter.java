package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment.mvp;

import android.support.v7.app.AppCompatActivity;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

public class ToEatPresenter {

    AppCompatActivity activity;
    SchedulerProvider schedulerProvider;
    ToEatView toEatView;
    ToEatModel toEatModel;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ToEatPresenter(AppCompatActivity activity, SchedulerProvider schedulerProvider, ToEatView toEatView, ToEatModel toEatModel) {
        this.activity = activity;
        this.schedulerProvider = schedulerProvider;
        this.toEatView = toEatView;
        this.toEatModel = toEatModel;
    }

    public void onCreateView() {

//        toEatView.see_all_popular_list.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(activity, CategoriesGridActivity.class);
//                activity.startActivity(intent);
//            }
//        });
    }

    public void onDestroyView() {
        compositeDisposable.clear();
    }
}
