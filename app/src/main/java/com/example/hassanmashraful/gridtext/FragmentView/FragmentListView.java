package com.example.hassanmashraful.gridtext.FragmentView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hassanmashraful.gridtext.Adapter.ListAdapter;
import com.example.hassanmashraful.gridtext.Adapter.SwapListItemDelete;
import com.example.hassanmashraful.gridtext.R;
import com.example.hassanmashraful.gridtext.Receipt_Food;

import java.util.ArrayList;

/**
 * Created by Hassan M.Ashraful on 8/24/2016.
 */
public class FragmentListView extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Receipt_Food> receipt_foods = new ArrayList<>();
    private ListAdapter adapter_list;
    Float sum = 0f;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list_main, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycleListView);
        adapter_list = new ListAdapter(getReceipt_foods(), getActivity());
        recyclerView.setAdapter(adapter_list);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        //Swapping item will delete row items
        ItemTouchHelper.Callback callback = new SwapListItemDelete(adapter_list);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);

        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(mMessageReceiver,
                new IntentFilter("grid-message"));

        return rootView;
    }


    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent
            String itemName = intent.getStringExtra("name");
            String price = intent.getStringExtra("price");
            String quantity = intent.getStringExtra("quantity");
            setReceipt_foods(itemName, quantity, price);
            updateInfo();
        }
    };


    public void setReceipt_foods(String name, String quantity, String price) {

        receipt_foods.add(new Receipt_Food(name, quantity, price));

    }

    public ArrayList<Receipt_Food> getReceipt_foods() {
        Toast.makeText(getActivity(), receipt_foods.size() + " SIZE", Toast.LENGTH_SHORT).show();


        return receipt_foods;

    }

    public void updateInfo() {
        //setReceipt_foods(name, "1", price);
        recyclerView.setAdapter(adapter_list);
        //sum = sumMyIntValues(listView);
    }
/*
    public Float sumMyIntValues(ListView myList) {
        Float sum = 0f;
        for (int i = 0; i < myList.getCount(); i++) {
            View v = myList.getAdapter().getView(i, null, null);
            TextView myView = (TextView) v.findViewById(R.id.productPrice);
            //sum = sum + Integer.parseInt( myView.getText().toString() );
            //sum = sum + Float.parseFloat( myView.getText().toString() );
            sum = sum + Float.parseFloat(myView.getText().toString());
        }
        return sum;
    }




    public Float getSum() {
        return sum;
    }*/


}
