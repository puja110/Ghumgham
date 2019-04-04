package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toSleepFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puza.mvpapiimplementation.application.di.ApplicationComponent;
import com.example.puza.mvpapiimplementation.application.di.MainApplication;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toSleepFragment.di.DaggerToSleepComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toSleepFragment.di.ToSleepModule;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toSleepFragment.mvp.ToSleepPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toSleepFragment.mvp.ToSleepView;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToSleepFragment extends Fragment {

    private ApplicationComponent appComponent;

    @Inject
    ToSleepPresenter toSleepPresenter;

    @Inject
    ToSleepView toSleepView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DaggerToSleepComponent.builder()
                .applicationComponent(MainApplication.get(getActivity()).getApplicationComponent())
                .toSleepModule(new ToSleepModule((AppCompatActivity) getActivity()))
                .build()
                .inject(this);

        ButterKnife.bind(this, getActivity());

        toSleepPresenter.onCreateView();

        return toSleepView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        toSleepPresenter.onDestroyView();

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}