package com.example.puza.mvpapiimplementation.modules.main.activities.setting.di;

import com.example.puza.mvpapiimplementation.application.di.ApplicationComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.setting.SettingActivity;

import dagger.Component;

@SettingScope
@Component(modules = SettingModule.class,dependencies = ApplicationComponent.class)
public interface SettingComponent {
    void inject(SettingActivity popularPlacesListActivity);
}

