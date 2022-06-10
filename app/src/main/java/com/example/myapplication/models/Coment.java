package com.example.myapplication.models;

public class Coment {
    private String title_ccoment;
    private String description_coment;


    public Coment(String title_ccoment, String description_coment) {
        this.title_ccoment = title_ccoment;
        this.description_coment = description_coment;
    }

    public String gettitle_ccoment() {
        return title_ccoment;
    }

    public void settitle_ccoment(String title_ccoment) {
        this.title_ccoment = title_ccoment;
    }

    public String getdescription_coment() {
        return description_coment;
    }

    public void setdescription_coment(String description_coment) {
        this.description_coment = description_coment;
    }
    @Override
    public String toString(){
        return  "Protectora{"+ "title_ccoment" +title_ccoment+ '\'' +
                ", description_coment='" +description_coment + '\'' +
                '}';
    }
}
