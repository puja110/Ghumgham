package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toSleepFragment.di;

import com.example.puza.mvpapiimplementation.application.di.ApplicationComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toSleepFragment.ToSleepFragment;

import dagger.Component;

@ToSleepScope
@Component(modules = ToSleepModule.class, dependencies = ApplicationComponent.class)
public interface ToSleepComponent {

    void inject(ToSleepFragment toSleepFragment);
}
