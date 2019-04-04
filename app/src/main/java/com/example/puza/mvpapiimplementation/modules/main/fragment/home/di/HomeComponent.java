package com.example.puza.mvpapiimplementation.modules.main.fragment.home.di;

import com.example.puza.mvpapiimplementation.application.di.ApplicationComponent;
import com.example.puza.mvpapiimplementation.modules.main.fragment.home.HomeFragment;

import dagger.Component;

@HomeScope
@Component(modules = HomeModule.class, dependencies = ApplicationComponent.class)
public interface HomeComponent {

    void inject(HomeFragment homeFragment);

}