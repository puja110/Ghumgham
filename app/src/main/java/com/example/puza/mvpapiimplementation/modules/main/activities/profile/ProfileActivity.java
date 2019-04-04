package com.example.puza.mvpapiimplementation.modules.main.activities.profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.application.di.MainApplication;
import com.example.puza.mvpapiimplementation.modules.main.activities.profile.di.DaggerProfileComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.profile.di.ProfileModule;
import com.example.puza.mvpapiimplementation.modules.main.activities.profile.mvp.ProfilePresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.profile.mvp.ProfileView;
import com.example.puza.mvpapiimplementation.modules.main.activities.setting.di.SettingModule;
import com.example.puza.mvpapiimplementation.modules.main.activities.setting.mvp.SettingPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.setting.mvp.SettingView;

import javax.inject.Inject;

public class ProfileActivity extends AppCompatActivity {

    @Inject
    ProfilePresenter profilePresenter;

    @Inject
    ProfileView profileView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerProfileComponent.builder().applicationComponent(MainApplication.get(this).getApplicationComponent()).profileModule(new ProfileModule(this)).build().inject(this);
        setContentView(profileView);
        profilePresenter.onViewCreated();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        profilePresenter.onDestroy();
    }

}
