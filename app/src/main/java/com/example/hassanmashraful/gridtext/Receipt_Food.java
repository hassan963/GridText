package com.example.hassanmashraful.gridtext;

/**
 * Created by Hassan M.Ashraful on 8/24/2016.
 */
public class Receipt_Food {

    private String foodName;
    private String foodPrice;
    private String foodQuantity;

    private String showPrice;
    private String showQuantity;

    public String getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(String showPrice) {
        this.showPrice = showPrice;
    }

    public String getShowQuantity() {
        return showQuantity;
    }

    public void setShowQuantity(String showQuantity) {
        this.showQuantity = showQuantity;
    }

    public Receipt_Food() {
        this.foodQuantity = "1";
    }

    public Receipt_Food(String foodName, String foodQuantity, String foodPrice) {
        this.foodName = foodName;
        this.foodQuantity = foodQuantity;
        this.foodPrice = foodPrice;
        this.showPrice = foodPrice;
        this.showQuantity = foodQuantity;
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
