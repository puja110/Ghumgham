package com.example.puza.mvpapiimplementation.modules.main.fragment.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.application.network.historicalPlaceDao.HistoricalPlace;

import java.util.ArrayList;

public class HistoricalPlaceAdapter extends RecyclerView.Adapter<HistoricalPlaceAdapter.ViewHolder> {
        Context context;
    private ArrayList<HistoricalPlace> home_modelArrayList;

    public HistoricalPlaceAdapter(Context context, ArrayList<HistoricalPlace> home_modelArrayList) {
        this.context = context;
        this.home_modelArrayList = home_modelArrayList;
        }

    @Override
    public HistoricalPlaceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historical_place,parent,false);
            return new ViewHolder(view);
            }

    @Override
    public void onBindViewHolder(HistoricalPlaceAdapter.ViewHolder holder, int position) {
            holder.bitmap1.setImageResource(home_modelArrayList.get(position).getBitmap1());
            holder.imagers.setImageResource(home_modelArrayList.get(position).getImagers());
            holder.textdji.setText(home_modelArrayList.get(position).getTextdji());
            holder.textprice.setText(home_modelArrayList.get(position).getTextprice());
            }

    @Override
    public int getItemCount() {
            return home_modelArrayList.size();
            }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView bitmap1,imagers;
//        TextViewSFProDisplayRegular textdji;
//        MyTextView_SF_Pro_Display_Bold textprice;

        TextView textdji, textprice;

        public ViewHolder(View itemView) {
            super(itemView);
            bitmap1=itemView.findViewById(R.id.bitmap1);
            imagers=itemView.findViewById(R.id.imagers);
            textdji=itemView.findViewById(R.id.textdji);
            textprice=itemView.findViewById(R.id.textprice);


        }
    }
    }

