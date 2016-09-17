package com.example.hassanmashraful.gridtext;

/**
 * Created by Hassan M.Ashraful on 8/23/2016.
 */
public class Food_Item {

    private String name;
    private String price;
    private int img;
    private String quantity;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public Food_Item(String name, int img, String price, String quantity) {
        this.name = name;
        this.img = img;
        this.price = price;
        this.quantity = quantity;
    }

    public int getImage() {
        return img;
    }

    public void setImage(int image) {
        this.img = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}


