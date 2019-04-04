package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.todoFragment.di;

import android.support.v7.app.AppCompatActivity;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.todoFragment.mvp.ToDoModel;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.todoFragment.mvp.ToDoPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.todoFragment.mvp.ToDoView;

import dagger.Module;
import dagger.Provides;

@Module
public class ToDoModule {

    AppCompatActivity activity;

    public ToDoModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ToDoScope
    ToDoView toDoView() {
        return new ToDoView(activity);
    }

    @Provides
    @ToDoScope
    ToDoPresenter toDoPresenter(SchedulerProvider schedulerProvider, ToDoView toDoView, ToDoModel toDoModel){
        return  new ToDoPresenter(activity,schedulerProvider,toDoView,toDoModel);
    }

    @Provides
    @ToDoScope
    ToDoModel toDoModel(PreferencesManager preferencesManager, AppNetwork appNetwork){
        return new ToDoModel(activity,preferencesManager,appNetwork);
    }
}
