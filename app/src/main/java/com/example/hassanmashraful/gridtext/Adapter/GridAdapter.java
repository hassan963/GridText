package com.example.hassanmashraful.gridtext.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        View view = inflater.inflate(R.layout.fragment_grid_row, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view, context, foodItems);

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

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView foodImage;
        TextView productNameG;
        TextView foodPrice;
        Context context;

        ArrayList<Food_Item> food_items;

        public MyViewHolder(View itemView, Context context, ArrayList<Food_Item> food_items) {
            super(itemView);
            this.context = context;
            this.food_items = food_items;
            itemView.setOnClickListener(this);
            foodImage = (ImageView) itemView.findViewById(R.id.foodImage);
            productNameG = (TextView) itemView.findViewById(R.id.productNameG);
            foodPrice = (TextView) itemView.findViewById(R.id.foodPrice);


        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Food_Item food_item = this.food_items.get(position);
            Intent intent = new Intent("grid-message");
            //            intent.putExtra("quantity",Integer.parseInt(quantity.getText().toString()));
            intent.putExtra("name", food_item.getName());
            intent.putExtra("price", food_item.getPrice());
            intent.putExtra("quantity", food_item.getQuantity());
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);

            Toast.makeText(context, "Pos: " + position, Toast.LENGTH_SHORT).show();
        }
    }

}
