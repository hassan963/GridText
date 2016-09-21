package com.example.hassanmashraful.gridtext.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hassanmashraful.gridtext.FragmentView.FragmentChart;
import com.example.hassanmashraful.gridtext.R;

/**
 * Created by Hassan M.Ashraful on 9/21/2016.
 */
public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_activity);

        if (getSupportFragmentManager().findFragmentById(R.id.barChartFrag) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.barChartFrag, new FragmentChart()).commit();
        }

    }
}
