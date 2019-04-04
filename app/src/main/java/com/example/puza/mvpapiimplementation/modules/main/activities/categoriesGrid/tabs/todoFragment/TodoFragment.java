package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.todoFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puza.mvpapiimplementation.application.di.ApplicationComponent;
import com.example.puza.mvpapiimplementation.application.di.MainApplication;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.todoFragment.di.DaggerToDoComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.todoFragment.di.ToDoModule;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.todoFragment.mvp.ToDoPresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.todoFragment.mvp.ToDoView;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class TodoFragment extends Fragment {

    private ApplicationComponent appComponent;

    @Inject
    ToDoPresenter toDoPresenter;

    @Inject
    ToDoView toDoView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DaggerToDoComponent.builder()
                .applicationComponent(MainApplication.get(getActivity()).getApplicationComponent())
                .toDoModule(new ToDoModule((AppCompatActivity) getActivity()))
                .build()
                .inject(this);

        ButterKnife.bind(this, getActivity());

        toDoPresenter.onCreateView();

        return toDoView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        toDoPresenter.onDestroyView();

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
