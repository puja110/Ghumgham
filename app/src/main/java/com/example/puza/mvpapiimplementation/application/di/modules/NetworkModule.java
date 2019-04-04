package com.example.puza.mvpapiimplementation.application.di.modules;

import android.content.Context;

import com.example.puza.mvpapiimplementation.application.di.AppScope;
import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.Constants;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @AppScope
    @Provides
    public Cache cache(Context context) {
        return new Cache(new File(context.getCacheDir(), Constants.HTTP_DIR_CACHE), Constants.CACHE_SIZE);
    }

    @AppScope
    @Provides
    public PreferencesManager preferencesManager(Context context) {
        return new PreferencesManager(context);
    }

    @Provides
    @AppScope
    OkHttpClient provideOkHttpClient(PreferencesManager prefs) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .addNetworkInterceptor(new StethoInterceptor());

        return client.build();
    }

    @AppScope
    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder().client(okHttpClient)
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @AppScope
    @Provides
    public AppNetwork appNetwork(Retrofit retrofit) {
        return retrofit.create(AppNetwork.class);
    }

}


