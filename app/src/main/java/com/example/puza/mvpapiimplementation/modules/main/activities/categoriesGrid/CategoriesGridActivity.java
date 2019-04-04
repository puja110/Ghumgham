package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.puza.mvpapiimplementation.application.di.MainApplication;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.di.CategoryGridModule;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.di.DaggerCategoryGridComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.mvp.CategoryGridPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.mvp.CategoryGridView;

import javax.inject.Inject;

public class CategoriesGridActivity extends AppCompatActivity {

    @Inject
    CategoryGridPresenter categoryGridPresenter;

    @Inject
    CategoryGridView categoryGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerCategoryGridComponent.builder().applicationComponent(MainApplication.get(this).getApplicationComponent()).categoryGridModule(new CategoryGridModule(this)).build().inject(this);
        setContentView(categoryGridView);
        categoryGridPresenter.onViewCreated();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        categoryGridPresenter.onDestroy();
    }
}
