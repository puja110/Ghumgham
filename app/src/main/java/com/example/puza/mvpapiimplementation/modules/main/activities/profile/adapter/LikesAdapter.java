package com.example.puza.mvpapiimplementation.modules.main.activities.profile.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.application.network.LikesPlaceDao.LikesPlace;

import java.util.List;

public class LikesAdapter extends RecyclerView.Adapter<LikesAdapter.MyViewHolder> {

    private List<LikesPlace> itemList;
    Activity context;

    public LikesAdapter(Activity context, List<LikesPlace> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView likesImage;
        private TextView likesTitle;

        public MyViewHolder(View view) {
            super(view);

            likesImage = (ImageView) view.findViewById(R.id.likes_image);
            likesTitle = (TextView) view.findViewById(R.id.likes_title);
        }
    }

    @Override
    public LikesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_likes, parent, false);
        return new LikesAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LikesAdapter.MyViewHolder holder, final int position) {

        final LikesPlace items = itemList.get(position);

        holder.likesImage.setImageResource(items.getLikesPlaceImage());
        holder.likesTitle.setText(items.getLikesPlaceTitle());

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






