package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toSleepFragment.mvp;

import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import com.example.puza.mvpapiimplementation.R;

import butterknife.ButterKnife;

public class ToSleepView  extends FrameLayout {

    AppCompatActivity activity;

    public ToSleepView(AppCompatActivity activity) {
        super(activity);
        this.activity = activity;
        inflate(activity, R.layout.fragment_to_sleep, this);
        ButterKnife.bind(this);
    }
}
