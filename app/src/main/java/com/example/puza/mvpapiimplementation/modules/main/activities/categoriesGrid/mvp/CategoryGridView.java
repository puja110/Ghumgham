package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.mvp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.adapter.PagerTabAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryGridView extends FrameLayout implements TabLayout.OnTabSelectedListener {

    AppCompatActivity activity;

    //This is our tablayout
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    //This is our viewPager
    @BindView(R.id.pager)
    ViewPager viewPager;

    private TextView toolbarTitleGrid;

    public CategoryGridView(AppCompatActivity activity) {
        super(activity);
        this.activity = activity;
        inflate(activity, R.layout.activity_categories_grid, this);
        ButterKnife.bind(this);

        toolbarTitleGrid = (TextView)getRootView().findViewById(R.id.toolbarTitle);
        toolbarTitleGrid.setText("CATEGORY");

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("To  Do"));
        tabLayout.addTab(tabLayout.newTab().setText("To Eat"));
        tabLayout.addTab(tabLayout.newTab().setText("To Sleep"));

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //Creating our pager adapter
        PagerTabAdapter adapter=new PagerTabAdapter(activity.getSupportFragmentManager(),tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.addOnTabSelectedListener(this);

        /*------------------Category Grid Items--------------------------*/

//        pplRecyclerView = (RecyclerView)getRootView().findViewById(R.id.popularPlacesListRecyclerView);
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

        /*------------------------------------------------------------*/
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
