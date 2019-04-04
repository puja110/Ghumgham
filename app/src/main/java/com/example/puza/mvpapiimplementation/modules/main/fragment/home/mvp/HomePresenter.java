package com.example.puza.mvpapiimplementation.modules.main.fragment.home.mvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.puza.mvpapiimplementation.helper.SchedulerProvider;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.CategoriesGridActivity;
import com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.PopularPlacesListActivity;

import io.reactivex.disposables.CompositeDisposable;

public class HomePresenter {

    private AppCompatActivity activity;
    private final HomeView homeView;
    private final HomeModel homeModel;
    SchedulerProvider schedulerProvider;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public HomePresenter(AppCompatActivity activity,HomeView homeView, HomeModel homeModel, SchedulerProvider schedulerProvider) {
        this.activity = activity;
        this.homeView = homeView;
        this.homeModel = homeModel;
        this.schedulerProvider = schedulerProvider;
    }

    public void onCreateView() {
//        apiRecentServiceCall();

        homeView.see_all_popular_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, CategoriesGridActivity.class);
                activity.startActivity(intent);
            }
        });

        homeView.see_all_top_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, PopularPlacesListActivity.class);
                activity.startActivity(intent);

//                ReviewCallFragment fragment3 = new ReviewCallFragment();
//                android.support.v4.app.FragmentTransaction transaction = ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.frame_container, fragment3);
//                transaction.commit();

            }
        });

    }

//    private void apiRecentServiceCall() {
//        compositeDisposable.add(homeModel.getRecentProducts()
//                .subscribeOn(schedulerProvider.io())
//                .observeOn(schedulerProvider.ui())
//                .subscribe(this::onSuccessRecent, this::onerror));
//    }
//
//    private void onerror(Throwable throwable) {
//    }
//
//    private void onSuccessRecent(RecentProducts recentProducts) {
//
//        Log.e("recent",new Gson().toJson(recentProducts));
//
//        if (recentProducts.getStatus()){
//
//            if (recentProducts.getMessage() != null)
//            {
//                homeView.setRecentAdapter(recentProducts.getMessage());
//            }
//        }
//    }

    public void onDestroyView() {
        compositeDisposable.clear();
    }

}
