package com.example.hassanmashraful.gridtext.FragmentView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hassanmashraful.gridtext.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by Hassan M.Ashraful on 9/21/2016.
 */
public class FragmentChart extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.frag_chart, container, false);
        BarChart chart = (BarChart) rootView.findViewById(R.id.chart);

        BarData data = new BarData(getXAxisValues(), getDataSet());
        chart.setData(data);
        chart.setDescription("My Chart");
        chart.animateXY(2000, 2000);
        chart.invalidate();

        CustomMarkerView mv = new CustomMarkerView(getActivity(), R.layout.marker_view);

        // set the marker to the chart
        chart.setMarkerView(mv);

        return rootView;
    }

    private ArrayList<IBarDataSet> getDataSet() {
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(78650.000f, 0); // Jan
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(66460.000f, 1); // Feb
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(76740.000f, 2); // Mar
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(7790.000f, 3); // Apr
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(4240.000f, 4); // May
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(5670.000f, 5); // Jun
        valueSet1.add(v1e6);
        BarEntry v1e7 = new BarEntry(34690.000f, 6); // Jun
        valueSet1.add(v1e7);
        BarEntry v1e8 = new BarEntry(6890.000f, 7); // Jun
        valueSet1.add(v1e8);
        BarEntry v1e9 = new BarEntry(67840.000f, 8); // Jun
        valueSet1.add(v1e9);
        BarEntry v1e10 = new BarEntry(11000.000f, 9); // Jun
        valueSet1.add(v1e10);
        BarEntry v1e11 = new BarEntry(67890.000f, 10); // Jun
        valueSet1.add(v1e11);
        BarEntry v1e12 = new BarEntry(24570.000f, 11); // Jun
        valueSet1.add(v1e12);


        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Sales");
        //barDataSet1.setColor(Color.rgb(0, 155, 0));
        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);
        //BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Brand 2");
        //barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        dataSets.add(barDataSet1);
        //dataSets.add(barDataSet2);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("JAN");
        xAxis.add("FEB");
        xAxis.add("MAR");
        xAxis.add("APR");
        xAxis.add("MAY");
        xAxis.add("JUN");
        xAxis.add("JUL");
        xAxis.add("AUG");
        xAxis.add("SEP");
        xAxis.add("OCT");
        xAxis.add("NOV");
        xAxis.add("DEC");
        return xAxis;
    }


}
