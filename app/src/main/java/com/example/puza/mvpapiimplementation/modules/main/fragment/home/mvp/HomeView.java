package com.example.puza.mvpapiimplementation.modules.main.fragment.home.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.application.network.LikesPlaceDao.LikesPlace;
import com.example.puza.mvpapiimplementation.application.network.PopularPlacesDao.PopularPlaces;
import com.example.puza.mvpapiimplementation.application.network.TopPlacesDao.TopPlaces;
import com.example.puza.mvpapiimplementation.application.network.historicalPlaceDao.HistoricalPlace;
import com.example.puza.mvpapiimplementation.modules.main.activities.profile.adapter.LikesAdapter;
import com.example.puza.mvpapiimplementation.modules.main.fragment.home.adapter.HistoricalPlaceAdapter;
import com.example.puza.mvpapiimplementation.modules.main.fragment.home.adapter.PopularAdapter;
import com.example.puza.mvpapiimplementation.modules.main.fragment.home.adapter.TopAdapter;
import com.example.puza.mvpapiimplementation.modules.main.fragment.home.ui.fullScreenActivity.FullScreenActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeView extends FrameLayout {

    public AppCompatActivity activity;

    @BindView(R.id.search)
    EditText search;

    @BindView(R.id.sliderView)
    SliderLayout mDemoSlider;

    @BindView(R.id.pagesContainer)
    LinearLayout mLinearLayout;

    @BindView(R.id.see_all_popular_list)
    TextView see_all_popular_list;

    @BindView(R.id.see_all_top_list)
    TextView see_all_top_list;

//    @BindView(R.id.popularPlacesRecyclerView)
//    RecyclerView recentRecyclerView;

    /*---------------popular places items----------------------*/
    RecyclerView ppRecyclerView;
    private RecyclerView.LayoutManager ppLayoutManager;
    PopularAdapter ppAdapter;
    List<PopularPlaces> ppItems;
    /*---------------------------------------------------*/

    /*---------------Top places items----------------------*/
    RecyclerView tRecyclerView;
    private RecyclerView.LayoutManager tLayoutManager;
    TopAdapter tAdapter;
    List<TopPlaces> tItems;
    /*---------------------------------------------------*/

    /*---------------Likes places items----------------------*/
    RecyclerView likesRecyclerView;
    private RecyclerView.LayoutManager likesLayoutManager;
    LikesAdapter likesPlaceAdapter;
    List<LikesPlace> likesItem;
    /*---------------------------------------------------*/

    //staggered recycler
    private HistoricalPlaceAdapter historicalPlaceAdapter;
    private RecyclerView hRecyclerview;
    private ArrayList<HistoricalPlace> historicalPlaces;

    Integer bitmap1[]={R.drawable.image,R.drawable.banner,R.drawable.image,R.drawable.banner2};
    Integer imagers[]={R.drawable.ic_action_like,R.drawable.ic_action_like,R.drawable.ic_action_like,R.drawable.ic_action_like};
    String textdji[]={"IKEA Chair","Mustang 1964 sxksxksxnjsxksmxksnxksmxlsknxkax;sxnxmkxalx,","Google Home","Google Home"};
    String textprice[]={"12,000","12,50,000","4,999","45,000"};

    public HomeView(@NonNull AppCompatActivity activity) {
        super(activity);
        this.activity = activity;
        inflate(activity, R.layout.fragment_home, this);

        // bind view using butter knife
        ButterKnife.bind(this);

        //hide the soft keyboard from inside a fragment
        activity.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

//        recentRecyclerView.setHasFixedSize(true);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity,
//                LinearLayoutManager.VERTICAL,
//                false);
//        recentRecyclerView.setLayoutManager(mLayoutManager);
//        recentRecyclerView.setItemAnimator(new DefaultItemAnimator());
//
//        recentRecyclerView.setAdapter(recentAdapter);

        /*------------------Popular places Items--------------------------*/

        ppRecyclerView = (RecyclerView)getRootView().findViewById(R.id.popularPlacesRecyclerView);
        ppItems = getPopularPlaceItem();
        ppRecyclerView.setHasFixedSize(true);
        ppLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        ppRecyclerView.setLayoutManager(ppLayoutManager);
        ppAdapter = new PopularAdapter(activity, ppItems);
        ppRecyclerView.setAdapter(ppAdapter);

        /*------------------------------------------------------------*/

        /*------------------Top places Items--------------------------*/

        tRecyclerView = (RecyclerView)getRootView().findViewById(R.id.topPlacesRecyclerView);
        tItems = getTopPlaceItem();

        tRecyclerView.setHasFixedSize(true);

        tLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        tRecyclerView.setLayoutManager(tLayoutManager);
        tAdapter = new TopAdapter(activity, tItems);
        tRecyclerView.setAdapter(tAdapter);

        /*------------------------------------------------------------*/

        /*------------------Likes places Items--------------------------*/

        likesRecyclerView = (RecyclerView)getRootView().findViewById(R.id.likesHomePlacesRecyclerView);
        likesItem = getLikesHomePlaceItem();

        likesRecyclerView.setHasFixedSize(true);

        likesLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        likesRecyclerView.setLayoutManager(likesLayoutManager);
        likesPlaceAdapter = new LikesAdapter(activity, likesItem);
        likesRecyclerView.setAdapter(likesPlaceAdapter);

        /*------------------------------------------------------------*/

        /*---------------------staggered recyclerview--------------------*/
        hRecyclerview = (RecyclerView) getRootView().findViewById(R.id.recyclerStaggered);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        hRecyclerview.setLayoutManager(layoutManager);
        hRecyclerview.setItemAnimator(new DefaultItemAnimator());

        historicalPlaces = new ArrayList<>();

        for (int i = 0; i < bitmap1.length; i++) {
            HistoricalPlace view1 = new HistoricalPlace(bitmap1[i],imagers[i],textdji[i],textprice[i]);
            historicalPlaces.add(view1);
        }
        historicalPlaceAdapter = new HistoricalPlaceAdapter(activity,historicalPlaces);
        hRecyclerview.setAdapter(historicalPlaceAdapter);
        /*--------------------------------------------------------------*/

        setupSlider();

    }

    private List<LikesPlace> getLikesHomePlaceItem() {

        likesItem = new ArrayList<LikesPlace>();

        likesItem.add(new LikesPlace(R.drawable.image, "Boudha"));
        likesItem.add(new LikesPlace(R.drawable.image, "Swyambhu"));
        likesItem.add(new LikesPlace(R.drawable.image, "Pashupatinath"));
        likesItem.add(new LikesPlace(R.drawable.image, "Banseshwor"));
        likesItem.add(new LikesPlace(R.drawable.image, "GOD"));
        likesItem.add(new LikesPlace(R.drawable.image, "White Gumba"));
        likesItem.add(new LikesPlace(R.drawable.image, "Kritipur"));

        return likesItem;
    }

    private List<PopularPlaces> getPopularPlaceItem() {
        ppItems = new ArrayList<PopularPlaces>();

        ppItems.add(new PopularPlaces(R.drawable.image, "Pashupatinath", "The Historic Temple."));
        ppItems.add(new PopularPlaces(R.drawable.image, "Swayambhunath", "The Monkey Temple."));
        ppItems.add(new PopularPlaces(R.drawable.image, "Boudhanath", "Of Cultural Interest."));
        ppItems.add(new PopularPlaces(R.drawable.image, "Durbar Square", "The Historical Monuments."));
        ppItems.add(new PopularPlaces(R.drawable.image, "White Gumba", "The Historic Gumba."));
        ppItems.add(new PopularPlaces(R.drawable.image, "Garden of Dreams", "Beautiful artificial plae."));
        ppItems.add(new PopularPlaces(R.drawable.image, "Narayaniti Darbar", "The Historic Museum."));
        ppItems.add(new PopularPlaces(R.drawable.image, "Godawari", "The beauty of Greenery."));

        return ppItems;
    }

    private List<TopPlaces> getTopPlaceItem() {
        tItems = new ArrayList<TopPlaces>();

        tItems.add(new TopPlaces(R.drawable.image, "Top 20 Heritage Sites of kathmandu"));
        tItems.add(new TopPlaces(R.drawable.image, "Top 10 places of kathmandu"));
        tItems.add(new TopPlaces(R.drawable.image, "Top 10 Hotels of kathmandu"));
        tItems.add(new TopPlaces(R.drawable.image, "Top 10 places of kathmandu"));
        tItems.add(new TopPlaces(R.drawable.image, "Top 10 places of kathmandu"));
        tItems.add(new TopPlaces(R.drawable.image, "Top 10 places of kathmandu"));
        tItems.add(new TopPlaces(R.drawable.image, "Top 10 places of kathmandu"));

        return tItems;
    }

    //slider
    private void setupSlider() {
        final HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Dashain Offer",R.drawable.banner);
        file_maps.put("Tools",R.drawable.banner2);
        file_maps.put("Instruments",R.drawable.banner4);

        for(String name : file_maps.keySet()){
            DefaultSliderView defaultSliderView = new DefaultSliderView(getContext());

            defaultSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider){

//                    Toast.makeText(getContext(), "clicked image=", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getContext(), FullScreenActivity.class).putExtra("filemap", new Gson().toJson(file_maps));
                    activity.startActivity(intent);
                }
            });

            // initialize a SliderLayout
            defaultSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            //add your extra information
            defaultSliderView.bundle(new Bundle());
            defaultSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(defaultSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(5000);
    }

//    public void setRecentAdapter(List<com.example.puza.mvpapiimplementation.application.network.RecentDao.Message> message) {
//        recentAdapter.showrecentlist(message);
//    }
}
