package com.example.puza.mvpapiimplementation.modules.main.activities.profile.di;


import com.example.puza.mvpapiimplementation.application.di.ApplicationComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.profile.ProfileActivity;

import dagger.Component;

@ProfileScope
@Component(modules = ProfileModule.class,dependencies = ApplicationComponent.class)
public interface ProfileComponent {
    void inject(ProfileActivity popularPlacesListActivity);
}
