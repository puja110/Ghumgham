package com.example.puza.mvpapiimplementation.modules.main.mvp;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.helper.BottomNavigationHelper;
import com.example.puza.mvpapiimplementation.modules.main.activities.profile.ProfileActivity;
import com.example.puza.mvpapiimplementation.modules.main.fragment.home.ui.map.MapActivity;
import com.example.puza.mvpapiimplementation.modules.main.fragment.home.HomeFragment;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.ReviewAndCallActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainView extends FrameLayout implements NavigationView.OnNavigationItemSelectedListener {

    AppCompatActivity activity;
    Toolbar toolbar;
    public TextView toolbarTitle;
    FragmentTransaction transaction;

    private static final String SELECTED_ITEM = "arg_selected_item";

    public @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.bottomNavigation)
    public BottomNavigationView  mBottomNav;

    public @BindView(R.id.navigationMenu)
    ImageView navigationMenu;

    //Navigation Drawer
    public @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.cordinate)
    CoordinatorLayout mDrawerContent;

    public MainView(AppCompatActivity activity) {
        super(activity);
        this.activity = activity;
        inflate(activity, R.layout.activity_main, this);
        ButterKnife.bind(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarTitle = (TextView)findViewById(R.id.toolbarTitle);

        /*------------------------------------ Navigation Drawer -----------------------------------*/
        drawer.setScrimColor(Color.TRANSPARENT);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(activity, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            private float scaleFactor = 6f;

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float slideX = drawerView.getWidth() * slideOffset;
                mDrawerContent.setTranslationX(slideX);
                mDrawerContent.setScaleX(1 - (slideOffset / scaleFactor));
                mDrawerContent.setScaleY(1 - (slideOffset / scaleFactor));
            }
        };

        drawer.setScrimColor(Color.TRANSPARENT);
        drawer.setDrawerElevation(1f);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        /*--------------------------------------------------------------------------------------------*/

        setUpBottomNavigation();
    }

    private void setUpBottomNavigation() {
        BottomNavigationHelper.removeShiftMode(mBottomNav);
        if (mBottomNav != null) {

            // Select first menu item by default and show Fragment accordingly.
            Menu menu = mBottomNav.getMenu();
            selectFragment(menu.getItem(1));
            mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    selectFragment(item);
                    return true;
                }
            });
        }
    }

    public void selectFragment(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.menu_home:
                HomeFragment fragment1 = new HomeFragment();
                transaction = ((FragmentActivity) activity).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, fragment1);
                toolbarTitle.setText("Home");
                transaction.commit();

                break;
            case R.id.menu_profile:

                Intent intent = new Intent(activity, ProfileActivity.class);
                activity.startActivity(intent);

                break;
            case R.id.menu_more:
                Intent i = new Intent(activity, MapActivity.class);
                activity.startActivity(i);

                break;
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.profile){
            HomeFragment fragment = new HomeFragment();
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container, fragment);
            transaction.commit();
        }else if (id == R.id.services){
            HomeFragment fragment = new HomeFragment();
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container, fragment);
            transaction.commit();
        }else if (id == R.id.packages){


        }else if (id == R.id.cart){

        }else if (id == R.id.about){

        }else if (id == R.id.gallery){

        }else if (id == R.id.booking){

        }else if (id == R.id.location){

        }else if (id == R.id.terms_conditions){

        }else if (id == R.id.logout){

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
