package com.example.puza.mvpapiimplementation.application.di.modules;

import android.app.Application;
import android.content.Context;

import com.example.puza.mvpapiimplementation.application.di.AppScope;
import com.example.puza.mvpapiimplementation.helper.RequestPermissionHandler;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Context context;

    public AppModule(Application application) {
        this.context = application.getApplicationContext();
    }

    @Provides
    @AppScope
    public Context context()
    {
        return context;
    }

    @Provides
    @AppScope
    public SchedulerProvider schedulerProvider() {
        return SchedulerProvider.getInstance();
    }

    @Provides
    @AppScope
    RequestPermissionHandler requestPermissionHandler(){
        return  new RequestPermissionHandler();
    }
}
