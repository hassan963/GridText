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

import java.util.ArrayList;

/**
 * Created by Hassan M.Ashraful on 9/8/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    //Context context;
    ArrayList<Food_Item> foodItems;
    private LayoutInflater inflater;
    public RecyclerAdapter(Context context, ArrayList<Food_Item> foodItem){
            this.foodItems = foodItem;
            inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.recycle_card_each_row, parent, false);

        MyViewHolder holder = new MyViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.productNameG.setText(foodItems.get(position).getName());
        holder.foodPrice.setText("$" + foodItems.get(position).getPrice());
        //Picasso.with().load(foodItems.get(position).getImage()).resize(200,200).centerCrop().into(holder.foodImage); //centerCrop().into(holder.foodImage);
        holder.foodImage.setImageResource(foodItems.get(position).getImage());
        //Picasso.with(c).load(foodItems.get(position).getImage()).resize(400,400).centerCrop().into(foodImage);

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
