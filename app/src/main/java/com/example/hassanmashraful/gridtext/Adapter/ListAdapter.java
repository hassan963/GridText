package com.example.hassanmashraful.gridtext.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hassanmashraful.gridtext.R;
import com.example.hassanmashraful.gridtext.Receipt_Food;

import java.util.ArrayList;

/**
 * Created by Hassan M.Ashraful on 9/16/2016.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<Receipt_Food> receiptFoods;
    private Context context;

    public ListAdapter(ArrayList<Receipt_Food> receiptFoods, Context context) {
        inflater = LayoutInflater.from(context);
        this.receiptFoods = receiptFoods;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.temp_layout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.productName.setText(receiptFoods.get(position).getFoodName());
        holder.productQuantity.setText(receiptFoods.get(position).getFoodQuantity());
        holder.productPrice.setText(receiptFoods.get(position).getFoodPrice());


    }

    @Override
    public int getItemCount() {
        return receiptFoods.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView productName, productQuantity, productPrice;
        ImageButton plusBTN;

        public MyViewHolder(View itemView) {
            super(itemView);

            productName = (TextView) itemView.findViewById(R.id.productName);
            productQuantity = (TextView) itemView.findViewById(R.id.productQuantity);
            productPrice = (TextView) itemView.findViewById(R.id.productPrice);
            plusBTN = (ImageButton) itemView.findViewById(R.id.plusBTN);

        }
    }

}
