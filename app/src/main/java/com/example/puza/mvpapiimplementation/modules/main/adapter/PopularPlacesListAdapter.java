package com.example.puza.mvpapiimplementation.modules.main.adapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.modules.main.activities.placeListDetail.PlaceDetailsActivity;
import com.example.puza.mvpapiimplementation.modules.main.activities.popularPlacesList.placeListDao.Datum;

import java.util.ArrayList;
import java.util.List;

public class PopularPlacesListAdapter extends RecyclerView.Adapter<PopularPlacesListAdapter.MyViewHolder> {

    private List<Datum> placeList = new ArrayList<>();
    Activity context;
    Datum items = null;

    ProgressDialog progressDialog;

    public PopularPlacesListAdapter(Activity activity) {
        this.context = activity;
    }

    public void showPlaceList(List<Datum> data) {

        if (data!=null){
            placeList.addAll(data);
        }
        notifyDataSetChanged();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
//        private ImageView placeImage;

        private TextView placeName, placeDescription, price;

        private CardView cardView;

        public MyViewHolder(View view) {
            super(view);

//          placeImage = (ImageView) view.findViewById(R.id.place_list_image);

            placeName = (TextView) view.findViewById(R.id.place_list_Name);
            placeDescription = (TextView) view.findViewById(R.id.place_list_description);

            cardView = (CardView)view.findViewById(R.id.popular_places_list_Card);
        }
    }


    @Override
    public PopularPlacesListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_popular_places, parent, false);
        return new PopularPlacesListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PopularPlacesListAdapter.MyViewHolder holder, final int position) {

        items= placeList.get(position);

        Log.e("data", items+"");

        //holder.placeImage.setImageResource(items.getPopularPlaceListImage());

        holder.placeName.setText(items.getName());
        holder.placeDescription.setText(items.getRating());

        holder.cardView.setOnClickListener(v -> {

            Log.e("jhgfd", String.valueOf(position));
            Intent intent = new Intent(context, PlaceDetailsActivity.class);
            intent.putExtra("message",String.valueOf(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return this.placeList.size();
    }

//    public void addPlaces(Datum places) {
//        Log.d(TAG, places.getName());
//        places.add(places);
//        notifyDataSetChanged();
//    }
}




