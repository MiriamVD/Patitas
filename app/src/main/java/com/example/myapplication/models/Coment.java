package com.example.myapplication.models;

public class Coment {
    private String titleComent;
    private String descriptionComent;


    public Coment(String titleComent, String descriptionComent) {
        this.titleComent = titleComent;
        this.descriptionComent = descriptionComent;
    }

    public String getTitleComent() {
        return titleComent;
    }

    public void setTitleComent(String titleComent) {
        this.titleComent = titleComent;
    }

    public String getDescriptionComent() {
        return descriptionComent;
    }

    public void setDescriptionComent(String descriptionComent) {
        this.descriptionComent = descriptionComent;
    }
    @Override
    public String toString(){
        return  "Protectora{"+ "titleComent" +titleComent+ '\'' +
                ", descriptionComent='" +descriptionComent + '\'' +
                '}';
    }
}
