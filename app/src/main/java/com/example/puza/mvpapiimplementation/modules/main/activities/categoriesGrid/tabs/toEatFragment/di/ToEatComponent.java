package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment.di;

import com.example.puza.mvpapiimplementation.application.di.ApplicationComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment.ToEatFragment;
import dagger.Component;

@ToEatScope
@Component(modules = ToEatModule.class,dependencies = ApplicationComponent.class)
public interface ToEatComponent {
    void inject(ToEatFragment toEatFragment);
}
