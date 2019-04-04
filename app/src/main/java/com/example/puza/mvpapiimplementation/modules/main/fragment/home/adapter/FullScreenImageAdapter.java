package com.example.puza.mvpapiimplementation.modules.main.fragment.home.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.helper.TouchImageView;

import java.util.ArrayList;

public class FullScreenImageAdapter extends PagerAdapter {

    Button btnClose;

    private Activity _activity;
    TouchImageView imgDisplay;

    ArrayList<Integer> sliderImages;
    private LayoutInflater inflater;

    // constructor
    public FullScreenImageAdapter(Activity activity, ArrayList<Integer> imagePaths) {
        this._activity = activity;
        this.sliderImages = imagePaths;
    }

    @Override
    public int getCount() {
        return this.sliderImages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

//        Button btnClose;

        inflater = (LayoutInflater) _activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.layout_fullscreen_image, container,
                false);
        imgDisplay = viewLayout.findViewById(R.id.imgDisplay);
        btnClose = (Button) viewLayout.findViewById(R.id.btnClose);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;

        Glide.with(_activity).load(sliderImages.get(position)).into(imgDisplay);

        try {
            Log.e("kslks", sliderImages.get(position).toString());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

//         close button click event
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _activity.finish();
            }

        });

        ((ViewPager) container).addView(viewLayout);

        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);
    }
}
