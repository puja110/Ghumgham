package com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.di;

import com.example.puza.mvpapiimplementation.application.di.ApplicationComponent;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.WriteReviewActivity;

import dagger.Component;

@WriteReviewScope
@Component(modules = WriteReviewModule.class, dependencies = ApplicationComponent.class)
public interface WriteReviewComponent {

    void inject(WriteReviewActivity writeReviewActivity);
}
