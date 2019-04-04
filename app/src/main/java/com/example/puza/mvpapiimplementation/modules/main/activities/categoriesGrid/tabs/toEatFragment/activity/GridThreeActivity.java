package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.puza.mvpapiimplementation.R;

public class GridThreeActivity extends AppCompatActivity {

    TextView gridThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_three);

        gridThree = (TextView)findViewById(R.id.toolbarTitle);
        gridThree.setText("GRID THREE");
    }
}
