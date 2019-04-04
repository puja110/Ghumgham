package com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.mvp;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.modules.main.adapter.PopularPlacesListAdapter;
import com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.placeListDao.Datum;

import java.util.List;

import butterknife.ButterKnife;

public class PopularPlacesListView extends FrameLayout {

    AppCompatActivity activity;

    PopularPlacesListAdapter popularPlacesListAdapter;

//    /*---------------popular places List items----------------------*/
    RecyclerView pplRecyclerView;
//    private RecyclerView.LayoutManager pplLayoutManager;
//    PopularPlacesListAdapter pplAdapter;
//    List<PopularPlacesList> pplItems;
//    /*---------------------------------------------------*/

    private TextView toolbarTitleGrid;
    public SwipeRefreshLayout swipeRefreshLayout;
//    private ProgressBar progressBar;

    public PopularPlacesListView(AppCompatActivity activity, PopularPlacesListAdapter popularPlacesListAdapter) {
        super(activity);
        this.activity = activity;
        this.popularPlacesListAdapter = popularPlacesListAdapter;
        inflate(activity, R.layout.activity_popular_places_list, this);
        ButterKnife.bind(this);

        toolbarTitleGrid = (TextView)getRootView().findViewById(R.id.toolbarTitle);

        toolbarTitleGrid.setText("POPULAR PLACES");

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
//        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        /*------------------Popular places Items--------------------------*/

        pplRecyclerView = (RecyclerView)getRootView().findViewById(R.id.popularPlacesListRecyclerView);
//        pplItems = getPopularPlaceListItem();
//        pplRecyclerView.setHasFixedSize(true);
//        pplLayoutManager = new LinearLayoutManager(
//                getContext(),
//                LinearLayoutManager.VERTICAL,
//                false
//        );
//        pplRecyclerView.setLayoutManager(pplLayoutManager);
//        pplAdapter = new PopularPlacesListAdapter(activity, pplItems);
//        pplRecyclerView.setAdapter(pplAdapter);


        pplRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity,
                LinearLayoutManager.VERTICAL,
                false);
        pplRecyclerView.setLayoutManager(mLayoutManager);
        pplRecyclerView.setItemAnimator(new DefaultItemAnimator());

        pplRecyclerView.setAdapter(popularPlacesListAdapter);

        /*------------------------------------------------------------*/
    }

    public void setPlaceListAdapter(List<Datum> data) {

        popularPlacesListAdapter.showPlaceList(data);

    }

//    private List<PopularPlacesList> getPopularPlaceListItem() {
//
//        pplItems = new ArrayList<PopularPlacesList>();
//
//        pplItems.add(new PopularPlacesList(R.drawable.image, "Pashupatinath", "The Historic Temple."));
//        pplItems.add(new PopularPlacesList(R.drawable.image, "Swayambhunath", "The Monkey Temple."));
//        pplItems.add(new PopularPlacesList(R.drawable.image, "Boudhanath", "Of Cultural Interest."));
//        pplItems.add(new PopularPlacesList(R.drawable.image, "Durbar Square", "The Historical Monuments."));
//        pplItems.add(new PopularPlacesList(R.drawable.image, "White Gumba", "The Historic Gumba."));
//        pplItems.add(new PopularPlacesList(R.drawable.image, "Garden of Dreams", "Beautiful artificial plae."));
//        pplItems.add(new PopularPlacesList(R.drawable.image, "Narayaniti Darbar", "The Historic Museum."));
//        pplItems.add(new PopularPlacesList(R.drawable.image, "Godawari", "The beauty of Greenery."));
//
//        return pplItems;
//    }
}
