package com.example.myapplication.models;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

import javax.sql.StatementEvent;

public class Protectora {
    private String image;
    private String name;
    private String phone;
    private String address;
    private String zipcode;

    public Protectora(String address,String name,String image,  String phone, String website, String zipcode) {
        this.address = address;
        this.name = name;
        this.image = image;
        this.phone = phone;
        this.website = website;
        this.zipcode = zipcode;

    }

    private String website;


public Protectora(){

}

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }


    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getzipcode() {
        return zipcode;
    }

    public void setzipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getwebsite() {
        return website;
    }

    public void setwebsite(String website) {
        this.website = website;
    }


}

