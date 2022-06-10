package com.example.myapplication.models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class Blog  {
    private String image;
    private String title;
    private String description;
    private String blogkey;
   // private Map<String, Object> coment;


    public Blog(String image, String title, String description, Map<String, Object> coment) {
        this.image = image;
        this.title = title;
        this.description = description;
       // this.coment = coment;

    }

    public Blog(){

    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

   /* public Map<String, Object> getComent() {
        return coment;
    }

    public void setComent(Map<String, Object> coment) {
        this.coment = coment;
    }*/

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

    public String getblogkey(){return this.blogkey;}

}
