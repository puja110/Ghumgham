package com.example.puza.mvpapiimplementation.application.di;

import android.content.Context;

import com.example.puza.mvpapiimplementation.application.di.modules.AppModule;
import com.example.puza.mvpapiimplementation.application.di.modules.DataBaseModule;
import com.example.puza.mvpapiimplementation.application.di.modules.GsonModule;
import com.example.puza.mvpapiimplementation.application.di.modules.NetworkModule;
import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;
import com.example.puza.mvpapiimplementation.helper.RequestPermissionHandler;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;

import dagger.Component;

@AppScope
@Component(modules = {AppModule.class, NetworkModule.class, DataBaseModule.class, GsonModule.class})
public interface ApplicationComponent {
    Context context();
    PreferencesManager preferencesManager();
    SchedulerProvider schedulerProvider();
    RequestPermissionHandler requestPermissionHandler();
    AppNetwork appNetwork();

}
