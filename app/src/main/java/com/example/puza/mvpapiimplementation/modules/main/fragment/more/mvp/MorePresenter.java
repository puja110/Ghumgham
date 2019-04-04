//package com.example.puza.mvpapiimplementation.modules.main.fragment.more.mvp;
//
//import android.util.Log;
//
//import com.example.puza.mvpapiimplementation.application.network.ProductCategoriesDAO.ProductCategories;
//import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
//import com.example.puza.mvpapiimplementation.modules.main.fragment.more.moreResponse.FeaturedProducts;
//import com.google.gson.Gson;
//
//import io.reactivex.disposables.CompositeDisposable;
//
//public class MorePresenter {
//
//    private final MoreView moreView;
//    private final MoreModel moreModel;
//    SchedulerProvider schedulerProvider;
//    private CompositeDisposable compositeDisposable = new CompositeDisposable();
//
//    public MorePresenter(MoreView moreView, MoreModel moreModel, SchedulerProvider schedulerProvider) {
//        this.moreView = moreView;
//        this.moreModel = moreModel;
//        this.schedulerProvider = schedulerProvider;
//    }
//
//    public void onCreateView() {
//        apiCall();
//        apiProductCategoryCall();
//    }
//
//    public void onDestroyView() {
//        compositeDisposable.clear();
//    }
//
//    public void apiCall(){
//
//        compositeDisposable.add(moreModel.getFeaturedList()
//        .subscribeOn(schedulerProvider.io())
//                .observeOn(schedulerProvider.ui())
//        .subscribe(this::onsuccess,this::onerror));
//    }
//
//    private void apiProductCategoryCall(){
//
//        compositeDisposable.add(moreModel.getCategoryList()
//                .subscribeOn(schedulerProvider.io())
//                .observeOn(schedulerProvider.ui())
//                .subscribe(this::onSuccessCategory, this::onerror));
//    }
//
//    private void onerror(Throwable throwable) {
//
//    }
//
//    private void onsuccess(FeaturedProducts featuredProducts) {
//
//        if (featuredProducts.getStatus() == true){
//
//            if (featuredProducts.getMessage() != null)
//            {
//                moreView.setadapter(featuredProducts.getMessage());
//            }
//        }
//
//    }
//
//    private  void onSuccessCategory(ProductCategories productCategories){
//
//        Log.e("success",new Gson().toJson(productCategories));
//
//        if (productCategories.getStatus() == true){
//
//            if (productCategories.getMessage() != null)
//            {
//                moreView.setCategoryAdapter(productCategories.getMessage());
//            }
//        }
//    }
//}
