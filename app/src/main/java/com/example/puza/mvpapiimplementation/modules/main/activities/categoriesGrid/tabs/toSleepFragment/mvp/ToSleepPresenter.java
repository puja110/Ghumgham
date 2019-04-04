package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toSleepFragment.mvp;

import android.support.v7.app.AppCompatActivity;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class ToSleepPresenter {

    AppCompatActivity activity;
    SchedulerProvider schedulerProvider;
    ToSleepView toSleepView;
    ToSleepModel toSleepModel;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ToSleepPresenter(AppCompatActivity activity, SchedulerProvider schedulerProvider, ToSleepView toSleepView, ToSleepModel toSleepModel) {
        this.activity = activity;
        this.schedulerProvider = schedulerProvider;
        this.toSleepView = toSleepView;
        this.toSleepModel = toSleepModel;
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
