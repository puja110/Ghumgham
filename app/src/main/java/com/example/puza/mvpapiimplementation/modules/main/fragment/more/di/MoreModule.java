//package com.example.puza.mvpapiimplementation.modules.main.fragment.more.di;
//
//import android.support.v7.app.AppCompatActivity;
//
//import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
//import com.example.puza.mvpapiimplementation.helper.PreferencesManager;
//import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
//import com.example.puza.mvpapiimplementation.modules.main.fragment.more.adapter.CategoryAdapter;
//import com.example.puza.mvpapiimplementation.modules.main.fragment.more.adapter.FeaturedProductsAdapter;
//import com.example.puza.mvpapiimplementation.modules.main.fragment.more.mvp.MoreModel;
//import com.example.puza.mvpapiimplementation.modules.main.fragment.more.mvp.MorePresenter;
//import com.example.puza.mvpapiimplementation.modules.main.fragment.more.mvp.MoreView;
//
//import dagger.Module;
//import dagger.Provides;
//
//@Module
//public class MoreModule {
//
//    private final AppCompatActivity activity;
//
//    public MoreModule(AppCompatActivity activity) {
//        this.activity = activity;
//    }
//
//    @MoreScope
//    @Provides
//    public MoreView moreView(FeaturedProductsAdapter featuredProductsAdapter, CategoryAdapter categoryAdapter) {
//        return new MoreView(activity, featuredProductsAdapter,categoryAdapter);
//    }
//
//    @MoreScope
//    @Provides
//    public MoreModel moreModel(AppNetwork appNetwork, PreferencesManager preferencesManager) {
//        return new MoreModel(activity, appNetwork, preferencesManager);
//    }
//
//
//    @MoreScope
//    @Provides
//    public MorePresenter morePresenter(MoreView moreView, MoreModel moreModel, SchedulerProvider schedulerProvider) {
//        return new MorePresenter(moreView, moreModel,schedulerProvider);
//    }
//
//    @MoreScope
//    @Provides
//    public FeaturedProductsAdapter featuredProductsAdapter() {
//        return new FeaturedProductsAdapter(activity);
//    }
//
//    @MoreScope
//    @Provides
//    public CategoryAdapter categoryAdapter(){
//        return new CategoryAdapter(activity);
//    }
//
//}
