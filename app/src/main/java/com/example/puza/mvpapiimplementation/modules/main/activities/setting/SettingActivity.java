package com.example.puza.mvpapiimplementation.modules.main.activities.setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.puza.mvpapiimplementation.application.di.MainApplication;
import com.example.puza.mvpapiimplementation.modules.main.activities.setting.di.DaggerSettingComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.setting.di.SettingModule;
import com.example.puza.mvpapiimplementation.modules.main.activities.setting.mvp.SettingPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.setting.mvp.SettingView;

import javax.inject.Inject;

public class SettingActivity extends AppCompatActivity {

    @Inject
    SettingPresenter settingPresenter;

    @Inject
    SettingView settingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerSettingComponent.builder().applicationComponent(MainApplication.get(this).getApplicationComponent()).settingModule(new SettingModule(this)).build().inject(this);
        setContentView(settingView);
        settingPresenter.onViewCreated();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        settingPresenter.onDestroy();
    }
}
