package com.example.puza.mvpapiimplementation.helper;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SchedulerProvider extends Scheduler {

    @Nullable
    private static SchedulerProvider INSTANCE;
    private SchedulerProvider() {
    }

    @Override
    public Worker createWorker() {
        return null;
    }

    public static synchronized SchedulerProvider getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SchedulerProvider();
        }
        return INSTANCE;
    }
    @NonNull
    public Scheduler computation() {
        return Schedulers.computation();
    }
    @NonNull
    public Scheduler io() {
        return Schedulers.io();
    }
    @NonNull
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }

    @NonNull
    public Scheduler trempoline() {
        return Schedulers.trampoline();
    }

    public Scheduler newThread() {
        return Schedulers.newThread();
    }
}
