package com.example.myapplication;

import android.media.Image;

import javax.sql.StatementEvent;

public class Protectora {
    private Image imgProtectora;
    private String nameProtectora;
    private String descriptionProtectora;
    private String numberProtectora;

    private long id;

    public Protectora(Image imgProtectora, String nameProtectora, String descriptionProtectora, String numberProtectora, long id){
        this.imgProtectora = imgProtectora;
        this.nameProtectora = nameProtectora;
        this.descriptionProtectora = descriptionProtectora;
        this.numberProtectora = numberProtectora;
        this.id = id;
    }

    public Protectora(Image imgProtectora, String nameProtectora, String descriptionProtectora, String numberProtectora){
        this.imgProtectora = imgProtectora;
        this.nameProtectora = nameProtectora;
        this.descriptionProtectora = descriptionProtectora;
        this.numberProtectora = numberProtectora;
    }

    public String getDescriptionProtectora() {
        return descriptionProtectora;
    }

    public void setDescriptionProtectora(String descriptionProtectora) {
        this.descriptionProtectora = descriptionProtectora;
    }

    public Image getImgProtectora() {
        return imgProtectora;
    }

    public void setImgProtectora(Image imgProtectora) {
        this.imgProtectora = imgProtectora;
    }

    public String getNameProtectora() {
        return nameProtectora;
    }

    public void setNameProtectora(String nameProtectora) {
        this.nameProtectora = nameProtectora;
    }

    public String getNumberProtectora() {
        return numberProtectora;
    }

    public void setNumberProtectora(String numberProtectora) {
        this.numberProtectora = numberProtectora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return  "Protectora{"+ "imgProtectora" +imgProtectora+ '\'' +
                ", nameProtectora='" + nameProtectora + '\'' +
                ", descriptionProtectora='" + descriptionProtectora + '\'' +
                ", numberProtectora='" + numberProtectora + '\'' +
                ", id=" + id +
                '}';
    }
}

