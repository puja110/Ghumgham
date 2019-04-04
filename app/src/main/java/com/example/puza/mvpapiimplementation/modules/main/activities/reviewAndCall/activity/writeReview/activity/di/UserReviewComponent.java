package com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.activity.di;

import com.example.puza.mvpapiimplementation.application.di.ApplicationComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.activity.UserReviewActivity;

import dagger.Component;

@UserReviewScope
@Component(modules = UserReviewModule.class, dependencies = ApplicationComponent.class)
public interface UserReviewComponent {

    void inject(UserReviewActivity userReviewActivity);
}
