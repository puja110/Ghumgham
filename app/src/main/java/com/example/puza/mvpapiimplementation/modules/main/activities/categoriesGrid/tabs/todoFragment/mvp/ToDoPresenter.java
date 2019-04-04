package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.todoFragment.mvp;

import android.support.v7.app.AppCompatActivity;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class ToDoPresenter {

    AppCompatActivity activity;
    SchedulerProvider schedulerProvider;
    ToDoView toDoView;
    ToDoModel toDoModel;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ToDoPresenter(AppCompatActivity activity, SchedulerProvider schedulerProvider, ToDoView toDoView, ToDoModel toDoModel) {
        this.activity = activity;
        this.schedulerProvider = schedulerProvider;
        this.toDoView = toDoView;
        this.toDoModel = toDoModel;
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
