package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment.mvp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridLayout;

import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment.activity.GridFourActivity;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment.activity.GridOneActivity;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment.activity.GridThreeActivity;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment.activity.GridTwoActivity;

import butterknife.ButterKnife;

public class ToEatView extends FrameLayout {

    AppCompatActivity activity;
    GridLayout mainGrid;

    public ToEatView(AppCompatActivity activity) {
        super(activity);
        this.activity = activity;
        inflate(activity, R.layout.fragment_to_eat, this);
        ButterKnife.bind(this);

        mainGrid = (GridLayout) getRootView().findViewById(R.id.mainGrid);

        //Set Event
        //setSingleEvent(mainGrid);

        setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (finalI == 0 && cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#effafc"));
                        Intent intent = new Intent(getContext(),GridOneActivity.class);
                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        activity.startActivity(intent);
                    }
                    else if (finalI == 1 && cardView.getCardBackgroundColor().getDefaultColor() == -1)
                    {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#effafc"));

                        Intent intent = new Intent(getContext(),GridTwoActivity.class);
                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        activity.startActivity(intent);

                    }
                    else if (finalI == 2 && cardView.getCardBackgroundColor().getDefaultColor() == -1)
                    {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#effafc"));

                        Intent intent = new Intent(getContext(),GridThreeActivity.class);
                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        activity.startActivity(intent);
                    }
                    else if (finalI == 3 && cardView.getCardBackgroundColor().getDefaultColor() == -1)
                    {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#effafc"));

                        Intent intent = new Intent(getContext(),GridFourActivity.class);
                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        activity.startActivity(intent);
                    }
                    else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
//                        Toast.makeText(getContext(), "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

//    private void setSingleEvent(GridLayout mainGrid) {
//        //Loop all child item of Main Grid
//        for (int i = 0; i < mainGrid.getChildCount(); i++) {
//            //You can see , all child item is CardView , so we just cast object to CardView
//            CardView cardView = (CardView) mainGrid.getChildAt(i);
//            final int finalI = i;
//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    if (finalI == 0)
//                    {
//                        Intent intent = new Intent(getContext(),GridOneActivity.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
//                        startActivity(intent);
//                    }
//                    else if (finalI == 1)
//                    {
//                        Intent intent = new Intent(getContext(),GridTwoActivity.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
//                        startActivity(intent);
//                    }
//                    else if (finalI == 2)
//                    {
//                        Intent intent = new Intent(getContext(),GridThreeActivity.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
//                        startActivity(intent);
//                    }
//                    else if (finalI == 3){
//                        Intent intent = new Intent(getContext(),GridFourActivity.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
//                        startActivity(intent);
//                    }
//                }
//            });
//        }
//    }
}
