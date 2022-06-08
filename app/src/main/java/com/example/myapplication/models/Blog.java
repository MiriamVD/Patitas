package com.example.myapplication.models;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Blog implements Serializable {
    
    private String title;
    private String description;
    private String title_coment;
    private String description_coment;




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

    public String getTitle_coment() {
        return title_coment;
    }

    public void setTitle_coment(String title_coment) {
        this.title_coment = title_coment;
    }

    public String getDescription_coment() {
        return description_coment;
    }

    public void setDescription_coment(String description_coment) {
        this.description_coment = description_coment;
    }


}
