package com.example.puza.mvpapiimplementation.modules.main.activities.profile.mvp;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.application.network.FavoritePlaceDao.FavoritePlace;
import com.example.puza.mvpapiimplementation.application.network.LikesPlaceDao.LikesPlace;
import com.example.puza.mvpapiimplementation.modules.main.activities.profile.adapter.FavoritePlaceAdapter;
import com.example.puza.mvpapiimplementation.modules.main.activities.profile.adapter.LikesAdapter;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileView  extends FrameLayout {

    AppCompatActivity activity;

    private TextView toolbarTitle;

    @BindView(R.id.settings)
    public ImageView settings;

    Toolbar toolbars;

    /*---------------Favorite places items----------------------*/
    RecyclerView favRecyclerView;
    private RecyclerView.LayoutManager favLayoutManager;
    FavoritePlaceAdapter favoritePlaceAdapter;
    List<FavoritePlace> favItem;
    /*---------------------------------------------------*/

    /*---------------Likes places items----------------------*/
    RecyclerView likesRecyclerView;
    private RecyclerView.LayoutManager likesLayoutManager;
    LikesAdapter likesPlaceAdapter;
    List<LikesPlace> likesItem;
    /*---------------------------------------------------*/

    public FloatingActionButton floatingActionButton;

    public ProfileView(AppCompatActivity activity) {
        super(activity);
        this.activity = activity;
        inflate(activity, R.layout.activity_profile, this);
        ButterKnife.bind(this);

        toolbarTitle = (TextView)getRootView().findViewById(R.id.toolbarsTitle);
        toolbarTitle.setText("My Profile");

        toolbars = findViewById(R.id.toolbars);
//        activity.setSupportActionBar(toolbars);

        floatingActionButton = (FloatingActionButton)getRootView().findViewById(R.id.floatingButton);

        /*------------------Favorite places Items--------------------------*/

        favRecyclerView = (RecyclerView)getRootView().findViewById(R.id.favPlacesRecyclerView);
        favItem = getFavPlaceItem();

        favRecyclerView.setHasFixedSize(true);

        favLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        favRecyclerView.setLayoutManager(favLayoutManager);
        favoritePlaceAdapter = new FavoritePlaceAdapter(activity, favItem);
        favRecyclerView.setAdapter(favoritePlaceAdapter);

        /*------------------------------------------------------------*/

        /*------------------Likes places Items--------------------------*/

        likesRecyclerView = (RecyclerView)getRootView().findViewById(R.id.likesPlacesRecyclerView);
        likesItem = getLikesPlaceItem();

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
    }

    private List<LikesPlace> getLikesPlaceItem() {

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

    private List<FavoritePlace> getFavPlaceItem() {

        favItem = new ArrayList<FavoritePlace>();

        favItem.add(new FavoritePlace(R.drawable.image, "Boudha"));
        favItem.add(new FavoritePlace(R.drawable.image, "Swyambhu"));
        favItem.add(new FavoritePlace(R.drawable.image, "Pashupatinath"));
        favItem.add(new FavoritePlace(R.drawable.image, "Banseshwor"));
        favItem.add(new FavoritePlace(R.drawable.image, "GOD"));
        favItem.add(new FavoritePlace(R.drawable.image, "White Gumba"));
        favItem.add(new FavoritePlace(R.drawable.image, "Kritipur"));

        return favItem;
    }
}
