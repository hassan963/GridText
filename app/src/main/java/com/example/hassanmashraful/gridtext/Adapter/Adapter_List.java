package com.example.hassanmashraful.gridtext.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hassanmashraful.gridtext.R;
import com.example.hassanmashraful.gridtext.Receipt_Food;

import java.util.ArrayList;

/**
 * Created by Hassan M.Ashraful on 8/24/2016.
 */
public class Adapter_List extends BaseAdapter {

    ArrayList<Receipt_Food> receiptFoods;
    Context c;

    public Adapter_List(Context c, ArrayList<Receipt_Food> receiptFoods) {
        this.receiptFoods = receiptFoods;
        this.c = c;
    }

    @Override
    public int getCount() {
        return receiptFoods.size();
    }

    @Override
    public Object getItem(int position) {
        return receiptFoods.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        final LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){
            convertView = inflater.inflate(R.layout.temp_layout, parent, false);
        }

        final TextView productName, productQuantity, productPrice;
        ImageButton plusBTN = (ImageButton) convertView.findViewById(R.id.plusBTN);
        plusBTN.setTag(position);

        productName = (TextView) convertView.findViewById(R.id.productName);
        productQuantity = (TextView) convertView.findViewById(R.id.productQuantity);
        productPrice = (TextView) convertView.findViewById(R.id.productPrice);
        productName.setText(receiptFoods.get(position).getFoodName());
        productQuantity.setText(receiptFoods.get(position).getFoodQuantity());
        productPrice.setText(receiptFoods.get(position).getFoodPrice());



        plusBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer index = (Integer) v.getTag();
                receiptFoods.remove(index.intValue());
                notifyDataSetChanged();

            }
        });


        return convertView;
    }



}
