package com.example.myapplication.models;


import java.io.Serializable;
import java.util.ArrayList;

public class Blog  {
    private String image;
    private String title;
    private String description;
    private ArrayList<Coment> coment;
    private String title_coment;
    private String description_coment;

    public Blog(String image, String title, String description, ArrayList<Coment> coment, String title_coment, String description_coment) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.coment = coment;
        this.title_coment = title_coment;
        this.description_coment = description_coment;
    }

    public Blog(){

    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Coment> getComent() {
        return coment;
    }

    public void setComent(ArrayList<Coment> coment) {
        this.coment = coment;
    }

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
