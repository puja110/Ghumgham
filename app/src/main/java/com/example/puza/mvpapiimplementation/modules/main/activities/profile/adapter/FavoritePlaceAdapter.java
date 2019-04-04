package com.example.puza.mvpapiimplementation.modules.main.activities.profile.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.application.network.FavoritePlaceDao.FavoritePlace;

import java.util.List;

public class FavoritePlaceAdapter extends RecyclerView.Adapter<FavoritePlaceAdapter.MyViewHolder> {

    private List<FavoritePlace> itemList;
    Activity context;

    public FavoritePlaceAdapter(Activity context, List<FavoritePlace> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView favImage;
        private TextView favTitle;


        public MyViewHolder(View view) {
            super(view);

            favImage = (ImageView) view.findViewById(R.id.fav_image);
            favTitle = (TextView) view.findViewById(R.id.fav_title);

        }
    }

    @Override
    public FavoritePlaceAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_favorite, parent, false);
        return new FavoritePlaceAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FavoritePlaceAdapter.MyViewHolder holder, final int position) {

        final FavoritePlace items = itemList.get(position);

        holder.favImage.setImageResource(items.getFavPlaceImage());
        holder.favTitle.setText(items.getFavPlaceTitle());

//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                transport("card");
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}





