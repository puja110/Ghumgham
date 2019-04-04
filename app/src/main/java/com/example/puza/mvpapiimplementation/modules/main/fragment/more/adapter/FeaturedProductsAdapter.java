package com.example.puza.mvpapiimplementation.modules.main.fragment.more.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.modules.main.fragment.more.moreResponse.Message;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FeaturedProductsAdapter extends RecyclerView.Adapter<FeaturedProductsAdapter.MyViewHolder> {

    private Activity activity;
//    List<Message> messageproduct;

    List<Message> messageproduct = new ArrayList<>();

    public FeaturedProductsAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_featured_products, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Message items = messageproduct.get(position);

        if (items.getProduct() != null) {
            holder.title.setText(items.getProduct().getTitle());
            holder.price.setText(items.getProduct().getPrice());
            holder.product_slug.setText(items.getProduct().getProductSlug());
            holder.createdat.setText(items.getProduct().getCreatedAt());
            holder.productCondition.setText(items.getProduct().getProductCondition());

        }
        else {
            holder.title.setText("N/A");
            holder.price.setText("N/A");
            holder.product_slug.setText("N/A");
            holder.createdat.setText("N/A");
            holder.productCondition.setText("N/A");

        }

        if (items.getProduct()!= null) {
            Picasso.with(activity)
                    .load("https://www.biztray.com/products/thumb/" +items.getProduct().getImage1())
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.imageView);
        }else {
            Picasso.with(activity)
                    .load(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.imageView);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                transport("card");
            }
        });
    }

    @Override
    public int getItemCount() {
        return messageproduct.size();
    }


    public void showalllist(List<Message> message) {
        if (message!=null){
            messageproduct.addAll(message);
        }
        notifyDataSetChanged();

    }

//    private void transport(String fragmentName) {
//        fragment = null;
//        FragmentManager fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();
//
//        switch (fragmentName) {
//            case "card":
//
//                fragment = new NewFragment();
//                break;
//        }
//
//        if (fragment != null) {
//            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).addToBackStack(null).commit();
//        }
//    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title, price, product_slug, createdat, productCondition;
        private ImageView imageView;
        private CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            Context context = itemView.getContext();
            title = (TextView) itemView.findViewById(R.id.title);
            price = (TextView) itemView.findViewById(R.id.price);
            product_slug = (TextView) itemView.findViewById(R.id.product_slug);
            createdat = (TextView) itemView.findViewById(R.id.createdat);
            productCondition = (TextView)itemView.findViewById(R.id. productCondition);

            imageView = (ImageView) itemView.findViewById(R.id.image);

            cardView = (CardView)itemView.findViewById(R.id.featuredCardview);

        }
    }
}
