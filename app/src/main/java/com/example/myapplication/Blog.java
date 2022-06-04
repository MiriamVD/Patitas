package com.example.myapplication;

import android.graphics.drawable.Drawable;

public class Blog {

    private Drawable imgBlog;
    private String nameBlog;
    private String descriptionBlog;

    private long id;

    public Blog(Drawable imgBlog, String nameBlog, String descriptionBlog, long id) {
        this.imgBlog = imgBlog;
        this.nameBlog = nameBlog;
        this.descriptionBlog = descriptionBlog;
        this.id = id;
    }

    public Blog(Drawable imgBlog, String nameBlog, String descriptionBlog) {
        this.imgBlog = imgBlog;
        this.nameBlog = nameBlog;
        this.descriptionBlog = descriptionBlog;
    }

    public Drawable getImgBlog() {
        return imgBlog;
    }

    public void setImgBlog(Drawable imgBlog) {
        this.imgBlog = imgBlog;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getDescriptionBlog() {
        return descriptionBlog;
    }

    public void setDescriptionBlog(String descriptionBlog) {
        this.descriptionBlog = descriptionBlog;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return  "Blog{"+ "imgBlog" +imgBlog+ '\'' +
                ", nameBlog='" + nameBlog + '\'' +
                ", descriptionBlog='" + descriptionBlog + '\'' +
                ", id=" + id +
                '}';
    }
}
