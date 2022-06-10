package com.example.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.myapplication.models.Blog;
import com.example.myapplication.models.Protectora;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class AdapterBlog extends RecyclerView.Adapter<AdapterBlog.ViewHolderDatos> {
    private List<Blog> listaBlog;
    private ArrayList<Blog> listaOriginal;

    Context context;


    public void setListaBlog(List<Blog> listaBlog){
        this.listaBlog=listaBlog;
    }

    //genero un constructor

    public AdapterBlog(Context context,List<Blog> blog) {
        this.context=context;
        this.listaBlog = blog;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaBlog);

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
        Glide.with(context)
                .load(listaBlog.get(i).getImage())
                .into(holder.imgBlog);
        Blog blog =listaBlog.get(i);
        //obtenemos los datos de la lista
        String title = blog.gettitle();
        String description =blog.getdescription();


        holder.title.setText(title);
        holder.description.setText(description);


    }

    @Override
    //obtenemos la cantidad de items
    public int getItemCount() {

        return listaBlog.size();
    }

    public void filtrado(String searchView ) {
        int longitud = searchView.length();
        if(longitud==0){
            listaBlog.clear();
            listaBlog.addAll(listaOriginal);
        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Blog> collecion = listaBlog.stream().filter(i -> i.gettitle().toLowerCase().contains(searchView.toLowerCase())).collect(Collectors.toList());
                listaBlog.clear();
                listaBlog.addAll(collecion);

            }else {
                for (Blog blg: listaOriginal) {
                    if(blg.gettitle().toLowerCase().contains(searchView.toLowerCase(Locale.ROOT))){
                        listaBlog.add(blg);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    class ViewHolderDatos extends RecyclerView.ViewHolder {
        ImageView imgBlog;
        TextView title, description ;

        ViewHolderDatos(@NonNull View itemView) {

            super(itemView);
            //this.img= itemView.findViewById(R.id.imgProtectora);
            //Le pasamos la referencia del xml
            this.imgBlog = itemView.findViewById(R.id.imgBlog);
            this.title = itemView.findViewById(R.id.nameBlog);
            this.description= itemView.findViewById(R.id.descriptionBlog);


        }

    }
}