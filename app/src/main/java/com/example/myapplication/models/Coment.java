package com.example.myapplication.models;

public class Coment {
    private String description_coment;
    private String title_coment;



    public Coment(String description_coment, String title_coment) {
        this.description_coment = description_coment;
        this.title_coment = title_coment;

    }

    public Coment(){}

    public String gettitle_coment() {
        return title_coment;
    }

    public void settitle_coment(String title_coment) {
        this.title_coment = title_coment;
    }

    public String getdescription_coment() {
        return description_coment;
    }

    public void setdescription_coment(String description_coment) {
        this.description_coment = description_coment;
    }
}
