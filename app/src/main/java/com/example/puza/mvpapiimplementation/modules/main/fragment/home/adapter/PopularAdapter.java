package com.example.puza.mvpapiimplementation.modules.main.fragment.home.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.application.network.PopularPlacesDao.PopularPlaces;
import com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.PopularPlacesListActivity;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.MyViewHolder> {

    private List<PopularPlaces> itemList;
    Activity context;

    public PopularAdapter(Activity context, List<PopularPlaces> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView placeImage;
        private TextView placeName, placeDescription, price;

        private CardView popular_places_Card;

        public MyViewHolder(View view) {
            super(view);

            placeImage = (ImageView) view.findViewById(R.id.place_image);
            placeName = (TextView) view.findViewById(R.id.place_Name);
            placeDescription = (TextView) view.findViewById(R.id.place_description);

            popular_places_Card = (CardView)view.findViewById(R.id.popular_places_Card);

        }
    }

    @Override
    public PopularAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_popular_places, parent, false);
        return new PopularAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PopularAdapter.MyViewHolder holder, final int position) {

        final PopularPlaces items = itemList.get(position);

        holder.placeImage.setImageResource(items.getPopularPlaceImage());
        holder.placeName.setText(items.getPopularPlaceName());
        holder.placeDescription.setText(items.getPopularPlaceDescription());

        holder.popular_places_Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PopularPlacesListActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}




