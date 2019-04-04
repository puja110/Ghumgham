package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.todoFragment.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.application.network.categoryGridDao.CategoryGrid;

import java.util.List;

public class CategoryGridAdapter extends RecyclerView.Adapter<CategoryGridAdapter.MyViewHolder> {

    private Context context;
    ProgressDialog progressDialog;
    private List<CategoryGrid> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title, categoryGridDes;
        public ImageView thumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);
            title =(TextView) itemView.findViewById(R.id.categoryGridName);
            thumbnail = (ImageView) itemView.findViewById(R.id.imageGrid);
            categoryGridDes = (TextView)itemView.findViewById(R.id.categoryGridDes);

//            thumbnail.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimary), PorterDuff.Mode.SRC_IN); OR
//            thumbnail.setColorFilter(Color.argb(255, 22, 147, 128)); // White Tint
            thumbnail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    progressDialog = new ProgressDialog(context);
                    progressDialog.setMessage("Loading..."); // Setting Message
                    progressDialog.setTitle("Please wait"); // Setting Title
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
                    progressDialog.show(); // Display Progress Dialog
                    progressDialog.setCancelable(false);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(1000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            progressDialog.dismiss();

//                            AllServicesFragment fragment = new AllServicesFragment();
//                            FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
//                            transaction.replace(R.id.frame_container, fragment);
//                            transaction.addToBackStack(null);
//                            transaction.commit();
                        }
                    }).start();
                }
            });
        }
    }

    public CategoryGridAdapter(Context mContext, List<CategoryGrid> albumList) {
        this.context = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_categories_grid, parent, false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(final CategoryGridAdapter.MyViewHolder holder, int position) {
        CategoryGrid album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.categoryGridDes.setText(album.getCategoryGridDes());

        //locating album cover using glide library
        Glide.with(context).load(album.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
