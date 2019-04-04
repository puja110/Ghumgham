package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.di;
import com.example.puza.mvpapiimplementation.application.di.ApplicationComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.CategoriesGridActivity;

import dagger.Component;

@CategoryGridScope
@Component(modules = CategoryGridModule.class,dependencies = ApplicationComponent.class)
public interface CategoryGridComponent {
    void inject(CategoriesGridActivity categoriesGridActivity);
}

