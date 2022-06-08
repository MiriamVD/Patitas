package com.example.myapplication.models;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Blog implements Serializable {
    
    private String title;
    private String description;




    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }



}
