//package com.example.puza.mvpapiimplementation.modules.main.fragment.more.mvp;
//
//import android.support.v7.app.AppCompatActivity;
//
//import com.example.puza.mvpapiimplementation.R;
//import com.example.puza.mvpapiimplementation.application.network.AppNetwork;
//import com.example.puza.mvpapiimplementation.application.network.ProductCategoriesDAO.ProductCategories;
//import com.example.puza.mvpapiimplementation.helper.PreferencesManager;
//import com.example.puza.mvpapiimplementation.modules.main.fragment.more.moreResponse.FeaturedProducts;
//
//import io.reactivex.Observable;
//
//public class MoreModel {
//
//    private final AppNetwork appNetwork;
//    private AppCompatActivity activity;
//    private final PreferencesManager preferencesManager;
//
//    public MoreModel(AppCompatActivity activity, AppNetwork appNetwork, PreferencesManager preferencesManager) {
//        this.appNetwork =  appNetwork;
//        this.activity = activity;
//        this.preferencesManager = preferencesManager;
//    }
//
//    /*get the features list */
//    public Observable<FeaturedProducts> getFeaturedList() {
//        return appNetwork.getFeaturedList(activity.getResources().getString(R.string.securitykey));
//    }
//
//    /*get the Category list */
//    public Observable<ProductCategories> getCategoryList() {
//        return appNetwork.getProductCategoryList(activity.getResources().getString(R.string.securitykey));
//    }
//
//}
