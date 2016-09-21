package com.example.hassanmashraful.gridtext.FragmentView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hassanmashraful.gridtext.R;

/**
 * Created by Hassan M.Ashraful on 9/21/2016.
 */
public class FragmentReceipt extends Fragment {


    //totalTV,vatET,vatTotalTV,discountET,discountTV,netTotalTV

    TextView totalTV, vatTotalTV, discountTV, netTotalTV;
    EditText vatET, discountET;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_receipt, container, false);

        totalTV = (TextView) rootView.findViewById(R.id.totalTV);
        vatTotalTV = (TextView) rootView.findViewById(R.id.vatTotalTV);
        discountTV = (TextView) rootView.findViewById(R.id.discountTV);
        netTotalTV = (TextView) rootView.findViewById(R.id.netTotalTV);
        vatET = (EditText) rootView.findViewById(R.id.vatET);
        discountET = (EditText) rootView.findViewById(R.id.discountET);


        return rootView;
    }
}
