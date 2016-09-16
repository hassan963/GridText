package com.example.hassanmashraful.gridtext;

/**
 * Created by Hassan M.Ashraful on 8/23/2016.
 */
public class Food_Item {

    private String name;
    private String price;
    private int img;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }



    public Food_Item(String name, int img, String price) {
        this.name = name;
        this.img = img;
        this.price = price;
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


