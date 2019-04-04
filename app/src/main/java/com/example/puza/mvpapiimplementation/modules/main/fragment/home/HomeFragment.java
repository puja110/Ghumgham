package com.example.puza.mvpapiimplementation.modules.main.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puza.mvpapiimplementation.application.di.ApplicationComponent;
import com.example.puza.mvpapiimplementation.application.di.MainApplication;
import com.example.puza.mvpapiimplementation.modules.main.fragment.home.di.DaggerHomeComponent;
import com.example.puza.mvpapiimplementation.modules.main.fragment.home.di.HomeModule;
import com.example.puza.mvpapiimplementation.modules.main.fragment.home.mvp.HomePresenter;
import com.example.puza.mvpapiimplementation.modules.main.fragment.home.mvp.HomeView;

import javax.inject.Inject;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {

    private ApplicationComponent appComponent;

    @Inject
    HomePresenter homePresenter;

    @Inject
    HomeView homeView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DaggerHomeComponent.builder()
                .applicationComponent(MainApplication.get(getActivity()).getApplicationComponent())
                .homeModule(new HomeModule((AppCompatActivity) getActivity()))
                .build()
                .inject(this);

        ButterKnife.bind(this, getActivity());

        homePresenter.onCreateView();

        return homeView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        homePresenter.onDestroyView();

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
