package com.example.puza.mvpapiimplementation.modules.main.activities.placeListDetail.mvp;

import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.puza.mvpapiimplementation.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlaceDetailView extends FrameLayout {

    AppCompatActivity activity;

//    Datum datum = new Datum();

    @BindView(R.id.placeListName)
    TextView placeListName;

    @BindView(R.id.placeListdescription)
    TextView placeListdescription;

    @BindView(R.id.reviewBtn)
    TextView reviewBtn;

    @BindView(R.id.lay)
    LinearLayout lay;

    @BindView(R.id.progressbar)
    ProgressBar progressBar;

//     public ProgressDialog progressBar;
//    private TextView toolbarTitleGrid;

    public PlaceDetailView(AppCompatActivity activity) {
        super(activity);
        this.activity = activity;
        inflate(activity, R.layout.activity_place_details, this);
        ButterKnife.bind(this);

//        toolbarTitleGrid = (TextView)getRootView().findViewById(R.id.toolbarTitle);
//        toolbarTitleGrid.setText("POPULAR PLACES");

//        if (activity.getIntent()!= null){
//            Log.e("sfdfgsf",new Gson().toJson(activity.getIntent().getSerializableExtra("message")));
//            datum = (Datum) activity.getIntent().getSerializableExtra("message");
//            placeListdescription.setText(datum.getDescription());
//            Log.e("jhgfhj",new Gson().toJson(datum));
//        }

    }

//    public ProgressDialog progressBar(){
//        progressDialog = new ProgressDialog(activity);
//        progressDialog.setMessage("Loading..."); // Setting Message
//        progressDialog.setTitle("Please wait"); // Setting Title
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
//        progressDialog.show(); // Display Progress Dialog
//        progressDialog.setCancelable(false);
//        new Thread(() -> {
////                    try {
////                        Thread.sleep(500);
////                    } catch (Exception e) {
////                        e.printStackTrace();
////                    }
//
//        }).start();
//
//    }

    /*get the place list */
//    public Observable<PlaceList> getPlaceList() {
//        return appNetwork.getPlaceList();
//    }
}
