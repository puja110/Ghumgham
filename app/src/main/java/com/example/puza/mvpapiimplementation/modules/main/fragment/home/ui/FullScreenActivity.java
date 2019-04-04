package com.example.puza.mvpapiimplementation.modules.main.fragment.home.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

import com.example.puza.mvpapiimplementation.R;
import com.example.puza.mvpapiimplementation.modules.main.fragment.home.adapter.FullScreenImageAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;

public class FullScreenActivity extends Activity {

    ArrayList<Integer> sliderImages = new ArrayList<>();

//    ProductDetailResponses productDetailResponses = new ProductDetailResponses();

//    private Utils utils;

    private FullScreenImageAdapter adapter;

    private ViewPager viewPager;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_full_screen);

        Intent intent = getIntent();

        if (intent!=null){
            Log.e("hjgjhg","kjgkj");
            Log.e("heyy",new Gson().toJson(getIntent().getStringExtra("filemap")));
            HashMap<String, Integer> hashMap = new Gson().fromJson(getIntent().getStringExtra("filemap"), new TypeToken<HashMap<String,Integer>>(){}.getType());
            sliderImages = new ArrayList<Integer>(hashMap.values());
            sliderImages.addAll(hashMap.values());
        }

//        Toast.makeText(this, new Gson().toJson(hashMap), Toast.LENGTH_SHORT).show();


//        intent.putExtra("hashMap", hashMap);

//        Bundle bundle = this.getIntent().getExtras();
//        if(bundle != null) {
//             = bundle.getSerializable("HashMap");
//        }

//        Bundle extras = getIntent().getExtras();
//        Bitmap bmp = (Bitmap) extras.getParcelable("imagebitmap");

        viewPager = (ViewPager) findViewById(R.id.pagerFullScreen);

//        utils = new Utils(getApplicationContext());
        Intent i = getIntent();

        int position = i.getIntExtra("position", 0);

//        sliderImages = (ArrayList<Integer>) this.getIntent().getSerializableExtra((SyncStateContract.Constants.DATA));
//        int[]  il = hashMap.values().toArray(new Integer[0]);



        Log.e("heyyyyyy",new Gson().toJson(sliderImages));

        adapter = new FullScreenImageAdapter(FullScreenActivity.this, sliderImages);

        viewPager.setAdapter(adapter);
        // displaying selected image first

        viewPager.setCurrentItem(position);
    }

//    @Override
//    public void hash(HashMap<String, Integer> hashMap) {
//        Log.e("heyyyy", hashMap.get("Tools").toString());
//    }
//
//    public Listener getInterface(){
//        return this;
//    }
}



