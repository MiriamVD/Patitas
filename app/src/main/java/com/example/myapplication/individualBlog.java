package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class individualBlog extends AppCompatActivity {
    private Drawable blogImg;
    private TextView blogTitle;
    private TextView blogDescription;
    private Blogs blogs;
    private Blog blog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        blogs = new Blogs();
        setContentView(R.layout.activity_individual_blog);

        Bundle extras= getIntent().getExtras();
        if(extras==null){
            finish();
            return;
        }

        //Drawable img= extras.getParcelable("img");
        String title= extras.getString("name");
        String description = extras.getString("description");
        long id = extras.getLong("id");

        blog = new Blog(blogImg,title,description,id);

        blogTitle=findViewById(R.id.blogTitle);
        blogDescription=findViewById(R.id.blogDescription);

        blogTitle.setText(String.valueOf(blog.getNameBlog()));
        blogDescription.setText(String.valueOf(blog.getDescriptionBlog()));
    }


}