package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Blogs extends AppCompatActivity implements View.OnClickListener  {
    private FloatingActionButton btnFloat;
    private RecyclerView recyclerViewBlog;
    private AdapterBlog adapterBlog;
    private List<Blog> listaBlog;
    private Drawable img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        recyclerViewBlog=findViewById(R.id.recyclerView2);
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerViewBlog.addItemDecoration(itemDecoration);
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        listaBlog = new ArrayList<>();
        listaBlog.add(new Blog( getResources().getDrawable(R.drawable.abandonado)," Cómo actuar ante una mascota abandonada o perdida",
                " Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ",1));
        listaBlog.add(new Blog( getResources().getDrawable(R.drawable.accesorios)," ¡Accesorios indispensables para tu mascota!",
                " Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ",2));
        listaBlog.add(new Blog( getResources().getDrawable(R.drawable.camas)," Las mejores camas para tus peludos",
                " Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ",3));
        listaBlog.add(new Blog( getResources().getDrawable(R.drawable.piensos)," ¿Cuáles son los mejores piensos del mercado?",
                " Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ",4));
        listaBlog.add(new Blog( getResources().getDrawable(R.drawable.erizo)," Cómo cuidar de un erizo",
                " Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ",5));
        adapterBlog = new AdapterBlog(listaBlog);

        btnFloat=findViewById(R.id.btnFloatHome);
        btnFloat.setOnClickListener((View.OnClickListener)this);
        recyclerViewBlog.setAdapter(adapterBlog);
        RecyclerView.LayoutManager mLayoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerViewBlog.setLayoutManager(mLayoutManager);
        recyclerViewBlog.setItemAnimator(new DefaultItemAnimator());

        recyclerViewBlog.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),recyclerViewBlog, new RecyclerTouchListener.ClickListener() {



            @Override
            public void onClick(View view, int position) {
                //pasar a la actividad PantallaModificar. Le pasamos los datos con el putExtra.
                Blog blogSeleccionado = listaBlog.get(position);

                Intent intent = new Intent(Blogs.this, individualBlog.class);
                intent.putExtra("id", blogSeleccionado.getId());
               // intent.putExtra("img", blogSeleccionado.getImgBlog());
                intent.putExtra("name", blogSeleccionado.getNameBlog());
                intent.putExtra("description", blogSeleccionado.getDescriptionBlog());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                Blog blogSeleccionado = listaBlog.get(position);
                Intent intent = new Intent(Blogs.this, individualBlog.class);
                intent.putExtra("id", blogSeleccionado.getId());
                //intent.putExtra("img", fileName);
                intent.putExtra("name", blogSeleccionado.getNameBlog());
                intent.putExtra("description", blogSeleccionado.getDescriptionBlog());
                startActivity(intent);
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