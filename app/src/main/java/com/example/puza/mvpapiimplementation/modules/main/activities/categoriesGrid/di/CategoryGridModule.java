package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.di;

import android.support.v7.app.AppCompatActivity;
import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.mvp.CategoryGridModel;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.mvp.CategoryGridPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.mvp.CategoryGridView;

import dagger.Module;
import dagger.Provides;

@Module
public class CategoryGridModule {

    public  final AppCompatActivity activity;

    public CategoryGridModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @CategoryGridScope
    CategoryGridView categoryGridView() {
        return new CategoryGridView(activity);
    }

    @Provides
    @CategoryGridScope
    CategoryGridPresenter categoryGridPresenter(SchedulerProvider schedulerProvider, CategoryGridView categoryGridView, CategoryGridModel categoryGridModel){
        return  new CategoryGridPresenter(activity,schedulerProvider,categoryGridView,categoryGridModel);
    }

    @Provides
    @CategoryGridScope
    CategoryGridModel categoryGridModel(PreferencesManager preferencesManager, AppNetwork appNetwork){
        return new CategoryGridModel(activity,preferencesManager,appNetwork);
    }
}
