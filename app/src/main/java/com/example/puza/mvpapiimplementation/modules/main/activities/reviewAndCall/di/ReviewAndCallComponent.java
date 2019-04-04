package com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.di;

import com.example.puza.mvpapiimplementation.application.di.ApplicationComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.ReviewAndCallActivity;

import dagger.Component;

@ReviewAndCallScope
@Component(modules = ReviewAndCallModule.class,dependencies = ApplicationComponent.class)
public interface ReviewAndCallComponent {
    void inject(ReviewAndCallActivity reviewAndCallActivity);
}
