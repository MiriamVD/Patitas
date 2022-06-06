package com.example.myapplication;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class AdapterBlog extends RecyclerView.Adapter<AdapterBlog.ViewHolderDatos> {
    private List<Blog> listaBlog;


    public void setListaBlog(List<Blog> listaBlog){
        this.listaBlog=listaBlog;
    }

    //genero un constructor

    public AdapterBlog(List<Blog> blog) {

        this.listaBlog = blog;
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


        //obtenemos la protectora de nuestra lista gracias al indice i
        Blog blog =listaBlog.get(i);
        //obtenemos los datos de la lista
        Drawable img = blog.getImgBlog();
        String name = blog.getNameBlog();
        String description =blog.getDescriptionBlog();

        //ponemos a los textview los datos con settext


        holder.img.setBackgroundDrawable(img);
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