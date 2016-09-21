package com.example.hassanmashraful.gridtext.FragmentView;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hassanmashraful.gridtext.Adapter.GridAdapter;
import com.example.hassanmashraful.gridtext.Food_Item;
import com.example.hassanmashraful.gridtext.R;
import com.example.hassanmashraful.gridtext.TempReceipt;

import java.util.ArrayList;

/**
 * Created by Hassan M.Ashraful on 8/24/2016.
 */
public class FragmentGridView extends Fragment {


    private String foodName;
    String foodPrice;

    private GridAdapter gridAdapter;
    onFoodItemListener onFoodItemListener;
    ArrayList<Food_Item> foodItems = new ArrayList<>();
    ArrayList<TempReceipt> tempReceipts = new ArrayList<>();
    int pos = 0;

    int[] images = {R.drawable.gridee, R.drawable.gridee, R.drawable.gridee, R.drawable.gridee, R.drawable.gridee, R.drawable.gridee, R.drawable.gride, R.drawable.gride, R.drawable.gride, R.drawable.gride};
    String[] names = {"Garlic Nan", "Caffe Latte", "Ice Cream with Ceramal", "Noodle Foodie", "Rice Organ", "Jesan", "Hemal", "FoodMe", "Noodle", "Rice Organ"};
    String[] prices = {"209", "103", "760", "120", "450", "23", "90", "87", "67", "109"};
    //Float[] prices = {209.00f, 103.01f, 760.00f, 120.00f, 450.00f, 23.00f, 90.00f, 87.04f, 67.09f, 109.03f};
    //private BackgroundTask backgroundTask;

    private Float p_price, row_p_total, total_product_price = 0f;

    private RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_recycle_grid, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycleGridView);
        gridAdapter = new GridAdapter(getActivity(), getFoodItems());
        recyclerView.setAdapter(gridAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);



        /*gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                foodName = names[position];
                foodPrice = prices[position];

                p_price = Float.valueOf(foodPrice);
                row_p_total = Float.valueOf(foodPrice)*2;
                foodPrice = row_p_total.toString();

                onFoodItemListener.setFoodItem(foodName, foodPrice);

                tempReceipts.add(new TempReceipt(foodName, p_price, 2, row_p_total));

                total_product_price = total_product_price + row_p_total;
                tempReceipt.setTotalPrice(total_product_price);
                
            }
        });*/
        return rootView;
    }


    public interface onFoodItemListener {

        void setFoodItem(String name, String price);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            onFoodItemListener = (onFoodItemListener) context;
        } catch (Exception e) {
        }

    }

    public void updateAdapter(int pos) {



        this.pos = pos;


    }

    public void setRice(int pos) {


        foodItems.clear();
        if (pos == 0) {
            foodItems.add(new Food_Item(names[0], images[0], prices[0], "1"));
            foodItems.add(new Food_Item(names[1], images[1], prices[1], "1"));
            foodItems.add(new Food_Item(names[2], images[2], prices[2], "1"));
            foodItems.add(new Food_Item(names[3], images[3], prices[3], "1"));
            foodItems.add(new Food_Item(names[4], images[4], prices[4], "1"));
            foodItems.add(new Food_Item(names[5], images[5], prices[5], "1"));
            foodItems.add(new Food_Item(names[6], images[6], prices[6], "1"));
            foodItems.add(new Food_Item(names[7], images[7], prices[7], "1"));
            foodItems.add(new Food_Item(names[8], images[8], prices[8], "1"));
            foodItems.add(new Food_Item(names[9], images[9], prices[9], "1"));
        } else if (pos == 1) {
            foodItems.add(new Food_Item(names[6], images[6], prices[6], "1"));
            foodItems.add(new Food_Item(names[7], images[7], prices[7], "1"));
            foodItems.add(new Food_Item(names[8], images[8], prices[8], "1"));
            foodItems.add(new Food_Item(names[9], images[9], prices[9], "1"));
        } else if (pos == 2) {
            foodItems.add(new Food_Item(names[2], images[2], prices[2], "1"));
            foodItems.add(new Food_Item(names[3], images[3], prices[3], "1"));
            foodItems.add(new Food_Item(names[8], images[8], prices[8], "1"));
            foodItems.add(new Food_Item(names[9], images[9], prices[9], "1"));
        }

        gridAdapter.notifyDataSetChanged();

    }

    public ArrayList<Food_Item> getFoodItems() {
        return foodItems;
    }


    public ArrayList<Food_Item> getDrinks() {
        ArrayList<Food_Item> foodItems = new ArrayList<>();

        foodItems.add(new Food_Item(names[6], images[6], prices[6], "1"));
        foodItems.add(new Food_Item(names[7], images[7], prices[7], "1"));
        foodItems.add(new Food_Item(names[8], images[8], prices[8], "1"));
        foodItems.add(new Food_Item(names[9], images[9], prices[9], "1"));

        return foodItems;
    }

    public ArrayList<Food_Item> getBuffo() {
        ArrayList<Food_Item> food_itemRICEs = new ArrayList<>();
        food_itemRICEs.add(new Food_Item(names[2], images[2], prices[2], "1"));
        food_itemRICEs.add(new Food_Item(names[3], images[3], prices[3], "1"));
        food_itemRICEs.add(new Food_Item(names[8], images[8], prices[8], "1"));
        food_itemRICEs.add(new Food_Item(names[9], images[9], prices[9], "1"));
        return food_itemRICEs;
    }


}
