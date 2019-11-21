package com.example.d_housepropertyproject.ui.mainfgt.home.act.bean;

import java.util.List;

public class UnitImageDetailsBean {
    private String title;
    private int number;
    List<String> images;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
