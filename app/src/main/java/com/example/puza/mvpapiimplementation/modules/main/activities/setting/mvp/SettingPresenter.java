package com.example.puza.mvpapiimplementation.modules.main.activities.setting.mvp;
import android.support.v7.app.AppCompatActivity;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class SettingPresenter {

    AppCompatActivity activity;
    SchedulerProvider schedulerProvider;
    SettingView settingView;
    SettingModel settingModel;

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public SettingPresenter(AppCompatActivity activity, SchedulerProvider schedulerProvider, SettingView settingView, SettingModel settingModel) {
        this.activity = activity;
        this.schedulerProvider = schedulerProvider;
        this.settingView = settingView;
        this.settingModel = settingModel;
    }

    public void onViewCreated() {

    }

    public void onDestroy() {
        compositeDisposable.clear();
    }

}
