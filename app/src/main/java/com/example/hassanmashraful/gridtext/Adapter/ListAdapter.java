package com.example.hassanmashraful.gridtext.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    private String foodName;

    public ListAdapter(ArrayList<Receipt_Food> receiptFoods, Context context) {
        inflater = LayoutInflater.from(context);
        this.receiptFoods = receiptFoods;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.temp_layout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view, context, receiptFoods);

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

    public void remove(int position) {
        receiptFoods.remove(position);
        notifyItemRemoved(position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView productName, productQuantity, productPrice;
        Button plusBTN, minusBTN;
        Context context;
        ArrayList<Receipt_Food> receiptFoods;

        public MyViewHolder(View itemView, Context context, ArrayList<Receipt_Food> receipt_foods) {
            super(itemView);
            this.context = context;
            this.receiptFoods = receipt_foods;
            productName = (TextView) itemView.findViewById(R.id.productName);
            productQuantity = (TextView) itemView.findViewById(R.id.productQuantity);
            productPrice = (TextView) itemView.findViewById(R.id.productPrice);
            plusBTN = (Button) itemView.findViewById(R.id.plusBTN);
            minusBTN = (Button) itemView.findViewById(R.id.minusBTN);
            plusBTN.setOnClickListener(this);
            minusBTN.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            Receipt_Food receipt_food = this.receiptFoods.get(position);

            if (v.getId() == plusBTN.getId()) {

                increment(receipt_food.getFoodPrice());

            } else if (v.getId() == minusBTN.getId()) {
                decrement(receipt_food.getFoodPrice());

            }


        }

        public void increment(String price) {
            int currentNos = Integer.parseInt(productQuantity.getText().toString());

            productQuantity.setText(String.valueOf(++currentNos));
            int currentPrice = Integer.parseInt(price);
            productPrice.setText(String.valueOf(currentNos * currentPrice));
        }

        public void decrement(String price) {
            int currentNos = Integer.parseInt(productQuantity.getText().toString());
            productQuantity.setText(String.valueOf(--currentNos));
            int currentPrice = Integer.parseInt(price);
            productPrice.setText(String.valueOf(currentNos * currentPrice));
        }


    }


}
