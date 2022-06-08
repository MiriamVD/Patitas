package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import com.example.myapplication.models.Blog;
import com.example.myapplication.models.Protectora;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Blogs extends AppCompatActivity implements View.OnClickListener  {
    private FloatingActionButton btnFloat;
    private RecyclerView recyclerViewBlog;
    private AdapterBlog adapterBlog;
    private ArrayList<Blog> listaBlog;
    private FirebaseDatabase db =FirebaseDatabase.getInstance();
    private DatabaseReference root2 = db.getReference().child("blogs");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        recyclerViewBlog=findViewById(R.id.recyclerView2);

        setTitle("Blog");
        listaBlog = new ArrayList<>();
        adapterBlog = new AdapterBlog(this,listaBlog);

        btnFloat=findViewById(R.id.btnFloatHome);
        btnFloat.setOnClickListener((View.OnClickListener)this);
        recyclerViewBlog.setAdapter(adapterBlog);
        RecyclerView.LayoutManager mLayoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerViewBlog.setLayoutManager(mLayoutManager);
        recyclerViewBlog.setItemAnimator(new DefaultItemAnimator());

        root2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds: snapshot.getChildren() ) {
                    Blog blog =ds.getValue(Blog.class);
                    listaBlog.add(blog);
                }
                adapterBlog.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        recyclerViewBlog.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),recyclerViewBlog, new RecyclerTouchListener.ClickListener() {


            @Override
            public void onClick(View view, int position) {
                //pasar a la actividad PantallaModificar. Le pasamos los datos con el putExtra.
                Blog blogSeleccionado = listaBlog.get(position);

                Intent intent = new Intent(Blogs.this, individualBlog.class);
               // intent.putExtra("img", blogSeleccionado.getImgBlog());
                intent.putExtra("object", blogSeleccionado);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFloatHome:
                Intent returned= new Intent(Blogs.this, MainActivity.class);
                startActivity(returned);
                break;
    }
}}