package com.example.hassanmashraful.gridtext;

/**
 * Created by Hassan M.Ashraful on 9/8/2016.
 */
public class TempReceipt {


    private String foodName;
    private Float foodPrice;
    private int foodQuantity;
    private Float totalPrice;

    public TempReceipt(){

    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public TempReceipt(String foodName, Float foodPrice, int foodQuantity, Float totalPrice) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodQuantity = foodQuantity;
        this.totalPrice = totalPrice;

    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Float getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Float foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

}
