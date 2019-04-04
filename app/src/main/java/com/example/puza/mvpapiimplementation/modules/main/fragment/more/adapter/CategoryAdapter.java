package com.example.puza.mvpapiimplementation.modules.main.fragment.more.adapter;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.application.network.ProductCategoriesDAO.Message;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private List<Message> mData = new ArrayList<>();
    AppCompatActivity activity;

    ProgressDialog progressDialog;

    public CategoryAdapter(AppCompatActivity activity) {
    }

    public void showCategoryList(List<Message> messageCategory) {
        if (messageCategory!=null){
            mData.addAll(messageCategory);
        }
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView id;
        private TextView category_name;
        private CircleImageView image;


        public MyViewHolder(View view) {
            super(view);

            id = (TextView)view.findViewById(R.id.id);
            category_name = (TextView) view.findViewById(R.id.category_name);
            //progressBar = (ProgressBar)  view.findViewById(R.id.progressBar);

            image = (CircleImageView) view.findViewById(R.id.image);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    progressDialog = new ProgressDialog(activity);
                    progressDialog.setMessage("Loading..."); // Setting Message
                    progressDialog.setTitle("Please wait"); // Setting Title
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
                    progressDialog.show(); // Display Progress Dialog
                    progressDialog.setCancelable(false);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(2000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            progressDialog.dismiss();

//                            CartFragment fragment = new CartFragment();
//                            FragmentTransaction transaction = ((FragmentActivity) mContext).getSupportFragmentManager().beginTransaction();
//                            transaction.replace(R.id.frame_container, fragment);
//                            transaction.commit();
                        }
                    }).start();
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_categories, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        final Message items = mData.get(position);

        if(items!= null) {
            holder.id.setText(items.getId());
            holder.category_name.setText(Html.fromHtml(items.getCategoryName()));
        }
        else{
            holder.id.setText("N/A");
            holder.category_name.setText("N/A");
        }

        if (items!=null){
            Picasso.with(activity)
                    .load("http://www.biztray.com/biztray-new/category/"+items.getImage())
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.image);
        }else{
            Picasso.with(activity)
                    .load(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.image);
        }


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
        return this.mData.size();
    }


}
