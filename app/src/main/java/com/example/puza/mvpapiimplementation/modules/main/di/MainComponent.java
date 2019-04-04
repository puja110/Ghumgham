package com.example.puza.mvpapiimplementation.modules.main.di;

import com.example.puza.mvpapiimplementation.application.di.ApplicationComponent;
import com.example.puza.mvpapiimplementation.modules.MainActivity;

import dagger.Component;

@MainScope
@Component(modules = MainModule.class,dependencies = ApplicationComponent.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}

