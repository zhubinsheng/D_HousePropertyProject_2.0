package com.example.d_housepropertyproject.ui.mainfgt.home.act.bean;

public class HomeGridBean {
    private String name;

    public HomeGridBean(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    private int img;
}
