package com.example.puza.mvpapiimplementation.application.di.modules;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.example.puza.mvpapiimplementation.application.dataprovider.local.DbManager;
import com.example.puza.mvpapiimplementation.application.dataprovider.local.DbOpenHelper;
import com.example.puza.mvpapiimplementation.application.di.AppScope;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.google.gson.Gson;
import com.squareup.sqlbrite2.BriteDatabase;
import com.squareup.sqlbrite2.SqlBrite;

import dagger.Module;
import dagger.Provides;

@Module
public class DataBaseModule {

    @Provides
    @NonNull
    @AppScope
    public SQLiteOpenHelper provideSQLiteOpenHelper(@NonNull Context context) {
        return new DbOpenHelper(context);
    }

    @Provides
    @NonNull
    @AppScope
    public BriteDatabase provideSqlBrite(SQLiteOpenHelper sqLiteOpenHelper, SchedulerProvider schedulerProvider) {
        return new SqlBrite.Builder()
                .build().wrapDatabaseHelper(sqLiteOpenHelper, schedulerProvider.io());
    }

    @Provides
    @NonNull
    @AppScope
    public DbManager provideDbManager(BriteDatabase briteDatabase, Gson gson) {
        return new DbManager(briteDatabase, gson);
    }

}
