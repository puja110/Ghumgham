package com.example.puza.mvpapiimplementation.modules.main.activities.setting.mvp;

import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import com.example.puza.mvpapiimplementation.R;
import butterknife.ButterKnife;

public class SettingView extends FrameLayout {

    AppCompatActivity activity;

//    private TextView toolbarTitleGrid;

    public SettingView(AppCompatActivity activity) {
        super(activity);
        this.activity = activity;
        inflate(activity, R.layout.activity_setting, this);
        ButterKnife.bind(this);

//        toolbarTitleGrid = (TextView)getRootView().findViewById(R.id.toolbarTitle);
//        toolbarTitleGrid.setText("Setting");

    }

}
