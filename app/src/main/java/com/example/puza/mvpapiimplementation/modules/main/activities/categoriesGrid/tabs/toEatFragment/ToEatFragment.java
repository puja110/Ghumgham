package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.puza.mvpapiimplementation.application.di.ApplicationComponent;
import com.example.puza.mvpapiimplementation.application.di.MainApplication;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment.di.DaggerToEatComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment.di.ToEatModule;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment.mvp.ToEatPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment.mvp.ToEatView;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class ToEatFragment extends Fragment {

    private ApplicationComponent appComponent;

    @Inject
    ToEatPresenter toEatPresenter;

    @Inject
    ToEatView toEatView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DaggerToEatComponent.builder()
                .applicationComponent(MainApplication.get(getActivity()).getApplicationComponent())
                .toEatModule(new ToEatModule((AppCompatActivity) getActivity()))
                .build()
                .inject(this);

        ButterKnife.bind(this, getActivity());

        toEatPresenter.onCreateView();

        return toEatView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        toEatPresenter.onDestroyView();

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
