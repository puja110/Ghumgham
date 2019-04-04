package com.example.puza.mvpapiimplementation.modules.main.activities.profile.di;

import android.support.v7.app.AppCompatActivity;

import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
import com.example.puza.mvpapiimplementation.helper.PreferencesManager;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.example.puza.mvpapiimplementation.modules.main.activities.profile.mvp.ProfileModel;
import com.example.puza.mvpapiimplementation.modules.main.activities.profile.mvp.ProfilePresenter;
import com.example.puza.mvpapiimplementation.modules.main.activities.profile.mvp.ProfileView;

import dagger.Module;
import dagger.Provides;

@Module
public class ProfileModule {

    public  final AppCompatActivity activity;

    public ProfileModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ProfileScope
    ProfileView profileView() {
        return new ProfileView(activity);
    }

    @Provides
    @ProfileScope
    ProfilePresenter profilePresenter(SchedulerProvider schedulerProvider, ProfileView profileView, ProfileModel profileModel){
        return  new ProfilePresenter(activity,schedulerProvider,profileView,profileModel);
    }

    @Provides
    @ProfileScope
    ProfileModel profileModel(PreferencesManager preferencesManager, AppNetwork appNetwork){
        return new ProfileModel(preferencesManager,appNetwork);
    }

//    @PopularPlacesListScope
//    @Provides
//    public PopularPlacesListAdapter popularPlacesListAdapter() {
//        return new PopularPlacesListAdapter(activity);
//    }

}
