package com.example.hassanmashraful.gridtext.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hassanmashraful.gridtext.Food_Item;
import com.example.hassanmashraful.gridtext.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Hassan M.Ashraful on 8/23/2016.
 */
public class Adapter_Grid extends BaseAdapter {

    ArrayList<Food_Item> foodItems;
    Context c;

    public Adapter_Grid(Context c, ArrayList<Food_Item> foodItem) {

        this.c = c;
        this.foodItems = foodItem;
    }


    //return total num of foodItems
    @Override
    public int getCount() {
        return foodItems.size();
    }

    @Override
    public Object getItem(int position) {
        return foodItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v;
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        GridView grid = (GridView)parent;
        int size = grid.getColumnWidth();

        if (convertView == null) {

            //First one for inflating view
            v = inflater.inflate(R.layout.grid_row_each_click, parent, false);

            //Second one for making gridview square but not working. But it getting the gridview fast. Below two lines can be deleted
            //v = LayoutInflater.from(c).inflate(R.layout.grid_row_each_click, null);
            //v.setLayoutParams(new GridView.LayoutParams(size, size));


        }else {
            v = convertView;
        }


        //convertView.setLayoutParams(new GridView.LayoutParams(size, size));
        //Views
        ImageView foodImage = (ImageView) v.findViewById(R.id.foodImage);
        //imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
        //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //imageView.setPadding(8, 8, 8, 8);

        TextView productNameG = (TextView) v.findViewById(R.id.productNameG);
        TextView foodPrice = (TextView) v.findViewById(R.id.foodPrice);

        foodImage.setImageResource(foodItems.get(position).getImage());
        productNameG.setText(foodItems.get(position).getName());
        foodPrice.setText("$" + foodItems.get(position).getPrice());
        // putting size variable in resize() method not working, giving postivie value needed
        Picasso.with(c).load(foodItems.get(position).getImage()).resize(400,400).centerCrop().into(foodImage);

        //Picasso.with(c).load(foodItems.get(position).getImage()).fit().centerInside().into(foodImage);
        return v;
    }
}
