package com.example.puza.mvpapiimplementation.application.di.modules;

import com.example.puza.mvpapiimplementation.application.di.AppScope;
import com.fatboyindustrial.gsonjodatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;

@Module
public class GsonModule {

    @Provides
    @AppScope
    public Gson gson()
    {
        return Converters.registerAll(new GsonBuilder())
//                .registerTypeAdapterFactory(AppTypeAdapterFactory.create())
                .setLenient()
                .create();
    }

}
