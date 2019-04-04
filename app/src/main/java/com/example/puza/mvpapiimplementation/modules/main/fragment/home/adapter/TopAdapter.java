package com.example.puza.mvpapiimplementation.modules.main.fragment.home.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.application.network.TopPlacesDao.TopPlaces;

import java.util.List;

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.MyViewHolder> {

    private List<TopPlaces> itemList;
    Activity context;

    public TopAdapter(Activity context, List<TopPlaces> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView topImage;
        private TextView topTitle;


        public MyViewHolder(View view) {
            super(view);

            topImage = (ImageView) view.findViewById(R.id.top_image);
            topTitle = (TextView) view.findViewById(R.id.top_title);

        }
    }

    @Override
    public TopAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_top_places, parent, false);
        return new TopAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TopAdapter.MyViewHolder holder, final int position) {

        final TopPlaces items = itemList.get(position);

        holder.topImage.setImageResource(items.getTopPlaceImage());
        holder.topTitle.setText(items.getTopPlaceTitle());

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}




