package com.darkcraft.pojo;

import java.io.InputStream;

public class Commodity {
    private String id;
    private String name;
    private int price;
    private String category;
    private InputStream img;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Commodity(String id, String name, int price, String category, InputStream img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public InputStream getImg() {
        return img;
    }

    public void setImg(InputStream img) {
        this.img = img;
    }
}
