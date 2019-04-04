package com.example.puza.mvpapiimplementation.modules.main.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.application.network.placeReviewsDao.Datum;
import com.example.puza.mvpapiimplementation.modules.main.activities.reviewAndCall.activity.writeReview.activity.UserReviewActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.MyViewHolder> {

    private List<Datum> itemList = new ArrayList<>();
    Activity context;

    public ReviewAdapter(Activity context) {
        this.context = context;
    }

    public void showPlaceReview(List<Datum> data) {

        Log.e("dafgfgta", new Gson().toJson(data));

        if (data!=null){
            itemList.addAll(data);
        }
        notifyDataSetChanged();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView reviewPlaceImage, reviewPersonImage, reviewRate;
        private TextView reviewPlaceName, reviewPlaceDescription, reviewPersonName, reviewRateNumber;

        private CardView cardView;

        public MyViewHolder(View view) {
            super(view);

            reviewPlaceImage = (ImageView) view.findViewById(R.id.reviewPlaceImage);
            reviewPersonImage = (ImageView) view.findViewById(R.id.reviewPersonImage);
            reviewRate = (ImageView) view.findViewById(R.id.reviewRate);
            reviewPlaceName = (TextView) view.findViewById(R.id.reviewPlaceName);
            reviewPlaceDescription = (TextView) view.findViewById(R.id.reviewPlaceDescription);
            reviewPersonName = (TextView) view.findViewById(R.id.reviewPersonName);
            reviewRateNumber = (TextView) view.findViewById(R.id.reviewRateNumber);

            cardView = (CardView) view.findViewById(R.id.reviewAndCallCard);
        }
    }

    @Override
    public ReviewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_review_and_call, parent, false);
        return new ReviewAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ReviewAdapter.MyViewHolder holder, final int position) {

        final Datum items = itemList.get(position);

        holder.reviewPlaceDescription.setText(items.getBody());
        holder.reviewPersonName.setText(items.getCustomer());
        holder.reviewRateNumber.setText(items.getStar().toString());

        holder.cardView.setOnClickListener(v -> {

            Intent intent = new Intent(context, UserReviewActivity.class);
            intent.putExtra("message",items);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        Log.e("size", String.valueOf(itemList.size()));
        return itemList.size();
    }
}





