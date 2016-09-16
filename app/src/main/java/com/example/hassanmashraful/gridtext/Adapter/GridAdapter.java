package com.example.hassanmashraful.gridtext.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hassanmashraful.gridtext.Food_Item;
import com.example.hassanmashraful.gridtext.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Hassan M.Ashraful on 9/9/2016.
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private ArrayList<Food_Item> foodItems;


    public GridAdapter(Context context, ArrayList<Food_Item> foodItem){
        inflater = LayoutInflater.from(context);
        this.foodItems = foodItem;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custom_row, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        holder.productNameG.setText(foodItems.get(position).getName());
        holder.foodPrice.setText("$" + foodItems.get(position).getPrice());

        Picasso.with(context).load(foodItems.get(position).getImage()).resize(200,200).centerCrop().into(holder.foodImage);
        holder.foodImage.setImageResource(foodItems.get(position).getImage());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView foodImage;
        TextView productNameG;
        TextView foodPrice;

        public MyViewHolder(View itemView) {
            super(itemView);

            foodImage = (ImageView) itemView.findViewById(R.id.foodImage);
            productNameG = (TextView) itemView.findViewById(R.id.productNameG);
            foodPrice = (TextView) itemView.findViewById(R.id.foodPrice);
        }
    }

}
