package com.example.hassanmashraful.gridtext.FragmentView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hassanmashraful.gridtext.Adapter.ListAdapter;
import com.example.hassanmashraful.gridtext.Adapter.SwapListItemDelete;
import com.example.hassanmashraful.gridtext.Database.DataBaseHelper;
import com.example.hassanmashraful.gridtext.R;
import com.example.hassanmashraful.gridtext.Receipt_Food;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Hassan M.Ashraful on 8/24/2016.
 */
public class FragmentListView extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Receipt_Food> receipt_foods = new ArrayList<>();
    private ListAdapter adapter_list;
    private int count = 1;
    DataBaseHelper dataBaseHelper;
    SQLiteDatabase sqLiteDatabase;

    TextView totalTV, vatTotalTV, discountTV, netTotalTV;
    EditText vatET, discountET;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_reycle_list, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycleListView);
        adapter_list = new ListAdapter(getReceipt_foods(), getActivity(), FragmentListView.this);
        recyclerView.setAdapter(adapter_list);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);


        //receipt item
        totalTV = (TextView) rootView.findViewById(R.id.totalTV);
        vatTotalTV = (TextView) rootView.findViewById(R.id.vatTotalTV);
        discountTV = (TextView) rootView.findViewById(R.id.discountTV);
        netTotalTV = (TextView) rootView.findViewById(R.id.netTotalTV);
        vatET = (EditText) rootView.findViewById(R.id.vatET);
        discountET = (EditText) rootView.findViewById(R.id.discountET);

        //Swapping item will delete row items
        ItemTouchHelper.Callback callback = new SwapListItemDelete(adapter_list, FragmentListView.this);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);

        discountTV.setText("0.00");

        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(mGridMessageReceiver,
                new IntentFilter("grid-message"));

        vatET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFOOD();
            }
        });

        discountET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFOOD();
            }
        });


        return rootView;
    }


    public BroadcastReceiver mGridMessageReceiver = new BroadcastReceiver() {
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
        showFOOD();

    }

    public ArrayList<Receipt_Food> getReceipt_foods() {
        //Toast.makeText(getActivity(), receipt_foods.size() + " SIZE", Toast.LENGTH_SHORT).show();

        return receipt_foods;

    }


    public void showFOOD() {
        int sum = 0, p_quantity;
        Float p_price = 0.00f, p_total = 0.00f, net_total = 0.00f;
        String p_name, vat, discount;

        Calendar c = Calendar.getInstance();

        int seconds = c.get(Calendar.SECOND);
        int minutes = c.get(Calendar.MINUTE);
        int hour = c.get(Calendar.HOUR);
        String time = hour + ":" + minutes + ":" + seconds;


        String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        String month = String.valueOf(c.get(Calendar.MONTH) + 1);
        String year = String.valueOf(c.get(Calendar.YEAR));
        //String date = day+"/"+month+"/"+year;

        dataBaseHelper = new DataBaseHelper(getActivity());
        sqLiteDatabase = dataBaseHelper.getWritableDatabase();

        for (int i = 0; i < receipt_foods.size(); i++) {

            //Log.v("DATA IN :: ", receipt_foods.get(i).getFoodName() + " " + receipt_foods.get(i).getFoodQuantity() + " " + receipt_foods.get(i).getFoodPrice());
            //Toast.makeText(getActivity(), receipt_foods.get(i).getFoodName() + " " + receipt_foods.get(i).getFoodQuantity() + " " + receipt_foods.get(i).getFoodPrice(), Toast.LENGTH_SHORT).show();
            sum += Integer.parseInt(receipt_foods.get(i).getShowPrice());

            p_price = Float.parseFloat(receipt_foods.get(i).getShowPrice());
            p_quantity = Integer.parseInt(receipt_foods.get(i).getShowQuantity());
            p_total = Float.valueOf(sum);
            p_name = receipt_foods.get(i).getFoodName();

            //int p_key, String p_name, float p_price, int p_quantity, float p_total
            //dataBaseHelper.addTempTableInfo(sqLiteDatabase, count, p_name, p_price, p_quantity);


        }
        //int p_key, String date, String month, String year, String time, Float p_total
        //dataBaseHelper.addReceiptTableInfo(sqLiteDatabase, count, day, month, year, time, p_total);
        totalTV.setText(String.valueOf(p_total));
        dataBaseHelper.close();
        count++;
        Toast.makeText(getActivity(), "Total ::::" + sum, Toast.LENGTH_SHORT).show();
        //receipt_foods.clear();

        //calculation
        vat = vatET.getText().toString();
        discount = discountET.getText().toString();
        if (vat.equals("")) {
            Float vatT = (p_total * 15) / 100;

            if (discount.equals("")) {
                net_total = p_total + vatT - 0;
            } else {
                net_total = p_total + vatT - Float.parseFloat(discount);
            }
            vatTotalTV.setText(String.valueOf(vatT));
            discountTV.setText(discount);
            netTotalTV.setText(String.valueOf(net_total));
        } else {
            Float vatT = p_total * Float.parseFloat(vat) / 100;

            if (discount.equals("")) {
                net_total = p_total + vatT - 0;
            } else {
                net_total = p_total + vatT - Float.parseFloat(discount);
            }

            vatTotalTV.setText(String.valueOf(vatT));
            discountTV.setText(discount);
            netTotalTV.setText(String.valueOf(net_total));
        }


    }



   /* public void dateTimeFormat(){
        Calendar c = Calendar.getInstance();

        int seconds = c.get(Calendar.SECOND);
        int minutes = c.get(Calendar.MINUTE);
        int hour = c.get(Calendar.HOUR);
        String time = hour+":"+minutes+":"+seconds;


        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH)+1;
        int year = c.get(Calendar.YEAR);
        String date = day+"/"+month+"/"+year;

        Toast.makeText(getActivity(), date + " " + time, Toast.LENGTH_LONG).show();
        Log.e("DATE  ", date);

    }*/


    public void updateInfo() {
        //setReceipt_foods(name, "1", price);
        recyclerView.setAdapter(adapter_list);
        adapter_list.notifyDataSetChanged();
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
