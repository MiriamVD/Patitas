package com.example.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.models.Blog;
import com.example.myapplication.models.Protectora;

import java.util.ArrayList;
import java.util.List;

public class AdapterBlog extends RecyclerView.Adapter<AdapterBlog.ViewHolderDatos> {
    private List<Blog> listaBlog;
    ArrayList<Blog> listaOriginalBlog;
    Context context;


    public void setListaBlog(List<Blog> listaBlog){
        this.listaBlog=listaBlog;
    }

    //genero un constructor

    public AdapterBlog(Context context,List<Blog> blog) {
        this.context=context;
        this.listaBlog = blog;
        listaOriginalBlog=new ArrayList<>();
        listaOriginalBlog.addAll(listaBlog);
    }

    @NonNull
    @Override
    // Instacianciamos nuestro recycler
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View lista_blogs= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lista_blogs,viewGroup,false);
        return new ViewHolderDatos(lista_blogs);
    }

    @Override
    //Encargado de actualizar los datos de un ViewHolder ya existente.
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int i) {

        Blog blog =listaBlog.get(i);
        //obtenemos los datos de la lista
        String name = blog.gettitle();
        String description =blog.getdescription();


        holder.name.setText(name);
        holder.description.setText(description);


    }

    @Override
    //obtenemos la cantidad de items
    public int getItemCount() {

        return listaBlog.size();
    }

    class ViewHolderDatos extends RecyclerView.ViewHolder {
        View img;
        TextView name, description ;

        ViewHolderDatos(@NonNull View itemView) {

            super(itemView);
            //this.img= itemView.findViewById(R.id.imgProtectora);
            //Le pasamos la referencia del xml
            this.img = itemView.findViewById(R.id.imgBlog);
            this.name = itemView.findViewById(R.id.nameBlog);
            this.description= itemView.findViewById(R.id.descriptionBlog);


        }

    }
}