package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.todoFragment.mvp;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;

import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.application.network.categoryGridDao.CategoryGrid;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.todoFragment.adapter.CategoryGridAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class ToDoView extends FrameLayout {

    AppCompatActivity activity;

    private RecyclerView recyclerViewGrid;
    private CategoryGridAdapter categoryGridAdapter;
    private List<CategoryGrid> categoryGridList;

    public ToDoView(AppCompatActivity activity) {
        super(activity);
        this.activity = activity;
        inflate(activity, R.layout.fragment_todo, this);
        ButterKnife.bind(this);

        /*-----------------------Category grid -------------------------------------*/
        recyclerViewGrid = (RecyclerView) getRootView().findViewById(R.id.recyclerGridView);

        categoryGridList = new ArrayList<CategoryGrid>();
        categoryGridAdapter = new CategoryGridAdapter(getContext(), categoryGridList);

        RecyclerView.LayoutManager gLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewGrid.setLayoutManager(gLayoutManager);
//        recyclerViewGrid.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(0),true));
        recyclerViewGrid.setItemAnimator(new DefaultItemAnimator());
        recyclerViewGrid.setAdapter(categoryGridAdapter);

        prepareServiceList();
        /*-----------------------service grid -------------------------------------*/
    }

    /*-------------------------------Grid Service--------------------------------------*/
    private void prepareServiceList(){
        int[] categoryList = new int[]{

                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
                R.drawable.image,
        };

        CategoryGrid s =new CategoryGrid("Hotel Anna Purna", categoryList[0], "The most popular Hotel of Kathmandu.");
        categoryGridList.add(s);

        s =new CategoryGrid("Hotel Anna Purna", categoryList[1], "The most popular Hotel of Kathmandu.");
        categoryGridList.add(s);

        s =new CategoryGrid("Hotel Anna Purna", categoryList[2], "The most popular Hotel of Kathmandu.");
        categoryGridList.add(s);

        s =new CategoryGrid("Hotel Anna Purna", categoryList[3], "The most popular Hotel of Kathmandu.");
        categoryGridList.add(s);

        s =new CategoryGrid("Hotel Anna Purna", categoryList[4], "The most popular Hotel of Kathmandu.");
        categoryGridList.add(s);

        s =new CategoryGrid("Hotel Anna Purna", categoryList[5], "The most popular Hotel of Kathmandu.");
        categoryGridList.add(s);

        s =new CategoryGrid("Hotel Anna Purna", categoryList[6], "The most popular Hotel of Kathmandu.");
        categoryGridList.add(s);

        s =new CategoryGrid("Hotel Anna Purna", categoryList[7], "The most popular Hotel of Kathmandu.");
        categoryGridList.add(s);

        s =new CategoryGrid("Hotel Anna Purna", categoryList[8], "The most popular Hotel of Kathmandu.");
        categoryGridList.add(s);

//        s =new CategoryGrid("Dwarika Hotel", categoryList[1], "The Hi");
//        categoryGridList.add(s);
//        s =new CategoryGrid("Home Appliance", categoryList[2]);
//        categoryGridList.add(s);
//        s =new CategoryGrid("Business Services", categoryList[3]);
//        categoryGridList.add(s);
//        s =new CategoryGrid("Electric", categoryList[4]);
//        categoryGridList.add(s);
//        s =new CategoryGrid("Repairing", categoryList[5]);
//        categoryGridList.add(s);
//        s =new CategoryGrid("Car Rental", categoryList[6]);
//        categoryGridList.add(s);
//        s =new CategoryGrid("Home Renovation ", categoryList[7]);
//        categoryGridList.add(s);
//        s =new CategoryGrid("Sanitory", categoryList[8]);
//        categoryGridList.add(s);

        categoryGridAdapter.notifyDataSetChanged();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration{

        private int spanCount;
        private int spacing;
        private boolean inclidEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean inclidEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.inclidEdge = inclidEdge;
        }

        public void getItemOffsets(Rect outrect, View view, RecyclerView parent, RecyclerView.State state){
            int position = parent.getChildAdapterPosition(view); //item position
            int column = position % spanCount; //item columns

            if (inclidEdge){
                outrect.left = spacing - column * spacing / spanCount;
                outrect.right = (column + 1) * spacing / spanCount;

                if (position < spanCount){
                    outrect.top = spacing;
                }
                outrect.bottom = spacing;
            }else {
                outrect.left = column * spacing / spanCount;
                outrect.right = spacing - (column + 1) * spacing / spanCount;
                if(position>=spanCount){
                    outrect.top = spacing;
                }
            }
        }
    }

    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    /*------------------------------------------------------------------------------------------*/

}

