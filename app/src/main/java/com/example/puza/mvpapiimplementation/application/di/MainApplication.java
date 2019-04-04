package com.example.puza.mvpapiimplementation.application.di;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.example.puza.mvpapiimplementation.application.di.modules.AppModule;
import com.facebook.stetho.Stetho;

public class MainApplication extends Application {

    public ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        applicationComponent = DaggerApplicationComponent.builder().appModule(new AppModule(this)).build();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static MainApplication get(Activity activity) {
        return (MainApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
