package com.example.puza.mvpapiimplementation.modules;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.application.di.MainApplication;
import com.example.puza.mvpapiimplementation.modules.main.di.DaggerMainComponent;
import com.example.puza.mvpapiimplementation.modules.main.di.MainModule;
import com.example.puza.mvpapiimplementation.modules.main.mvp.MainPresenter;
import com.example.puza.mvpapiimplementation.modules.main.mvp.MainView;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainPresenter mainPresenter;

    @Inject
    MainView mainView;

    private static final String SELECTED_ITEM = "arg_selected_item";
    private int mSelectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMainComponent.builder().applicationComponent(MainApplication.get(this).getApplicationComponent()).mainModule(new MainModule(this)).build().inject(this);
        setContentView(mainView);
        mainPresenter.onViewCreated();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, mSelectedItem);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        MenuItem homeItem = mainView.mBottomNav.getMenu().getItem(1);
        if (mSelectedItem != homeItem.getItemId()) {
            // select home item
            mainView.selectFragment(homeItem);
        } else if (mSelectedItem == homeItem.getItemId()) {
            onBackPressed();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDestroy();
    }
}
