package com.example.myapplication;

import android.media.Image;

import javax.sql.StatementEvent;

public class Protectora {
    private Image imgProtectora;
    private String nameProtectora;
    private String numberProtectora;
    private String directionProtectora;
    private String cdProtectora;
    private String websiteProtectora;


    private long id;

    public Protectora(String nameProtectora, String numberProtectora, String directionProtectora, String cdProtectora, String websiteProtectora, long id){
        //this.imgProtectora = imgProtectora;
        this.nameProtectora = nameProtectora;
        this.numberProtectora = numberProtectora;
        this.directionProtectora = directionProtectora;
        this.cdProtectora = cdProtectora;
        this.websiteProtectora = websiteProtectora;

        this.id = id;
    }

    public Protectora( String nameProtectora, String numberProtectora, String directionProtectora, String cdProtectora, String websiteProtectora){
      //  this.imgProtectora = imgProtectora;
        this.nameProtectora = nameProtectora;
        this.numberProtectora = numberProtectora;

        this.directionProtectora = directionProtectora;
        this.cdProtectora = cdProtectora;
        this.websiteProtectora = websiteProtectora;
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

    public String getDirectionProtectora() {
        return directionProtectora;
    }

    public void setDirectionProtectora(String directionProtectora) {
        this.directionProtectora = directionProtectora;
    }

    public String getCdProtectora() {
        return cdProtectora;
    }

    public void setCdProtectora(String cdProtectora) {
        this.cdProtectora = cdProtectora;
    }

    public String getWebsiteProtectora() {
        return websiteProtectora;
    }

    public void setWebsiteProtectora(String websiteProtectora) {
        this.websiteProtectora = websiteProtectora;
    }

    @Override
    public String toString(){
        return  "Protectora{"+ "imgProtectora" +imgProtectora+ '\'' +
                ", nameProtectora='" + nameProtectora + '\'' +
                ", numberProtectora='" + numberProtectora + '\'' +
                ", directionProtectora=" + directionProtectora + '\'' +
                ", cdProtectora=" + cdProtectora +'\''+
                ", websiteProtectora=" + websiteProtectora +'\''+
                ", id=" + id +
                '}';
    }
}

