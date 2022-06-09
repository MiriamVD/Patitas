package com.example.myapplication.models;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

import javax.sql.StatementEvent;

public class Protectora {
    private String imageUrl;
    private String name;
    private String phone;
    private String address;
    private String zipcode;

    public Protectora(String imageUrl, String name, String phone, String address, String zipcode, String website) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.zipcode = zipcode;
        this.website = website;
    }

    private String website;


public Protectora(){

}

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

