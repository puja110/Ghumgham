package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.todoFragment.di;

import com.example.puza.mvpapiimplementation.application.di.ApplicationComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.todoFragment.TodoFragment;

import dagger.Component;

@ToDoScope
@Component(modules = ToDoModule.class , dependencies = ApplicationComponent.class)
public interface ToDoComponent {

    void inject(TodoFragment todoFragment);
}
