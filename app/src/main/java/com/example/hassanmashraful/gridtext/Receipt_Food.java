package com.example.hassanmashraful.gridtext;

/**
 * Created by Hassan M.Ashraful on 8/24/2016.
 */
public class Receipt_Food {

    private String foodName;
    private String foodPrice;
    private String foodQuantity;

    public Receipt_Food() {
        this.foodQuantity = "1";
    }

    public Receipt_Food(String foodName, String foodQuantity, String foodPrice) {
        this.foodName = foodName;
        this.foodQuantity = foodQuantity;
        this.foodPrice = foodPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(String foodQuantity) {
        this.foodQuantity = foodQuantity;
    }
}
