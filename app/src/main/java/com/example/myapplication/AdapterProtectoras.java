package com.example.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.myapplication.models.Protectora;

import java.util.ArrayList;
import java.util.List;

public class AdapterProtectoras extends RecyclerView.Adapter<AdapterProtectoras.ViewHolderDatos> {
    private List<Protectora> listaProtectora;

    private Context context;
    private ImageView imgProtectora;


    public void setListaProtectora(List<Protectora> listaProtectora){
        this.listaProtectora=listaProtectora;
    }

    //genero un constructor

    public AdapterProtectoras( Context context, ArrayList<Protectora> protectora) {
        this.context =context;
        this.listaProtectora = protectora;

    }

    @NonNull
    @Override
    // Instacianciamos nuestro recycler
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View lista_protectora= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lista_protectoras,viewGroup,false);
        return new ViewHolderDatos(lista_protectora);
    }

    @Override
    //Encargado de actualizar los datos de un ViewHolder ya existente.
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int i) {

        Glide.with(context)
                .load(listaProtectora.get(i).getImageUrl())
                .into(holder.imgProtectora);

        //obtenemos la protectora de nuestra lista gracias al indice i
        Protectora protectora =listaProtectora.get(i);
        //obtenemos los datos de la lista

        String imageUrl = protectora.getImageUrl();
        String name = protectora.getname();
        String phone =protectora.getphone();
        String address = protectora.getaddress();
        String zipcode = protectora.getzipcode();
        String website = protectora.getwebsite();
        //ponemos a los textview los datos con settext

        holder.name.setText(name);
        holder.number.setText(phone);
        holder.direction.setText(address);
        holder.cd.setText(zipcode);
        holder.website.setText(website);

    }



    @Override
    //obtenemos la cantidad de items
    public int getItemCount() {

        return listaProtectora.size();
    }

    class ViewHolderDatos extends RecyclerView.ViewHolder {
        ImageView imgProtectora;
        TextView name, number, direction, cd, website ;

        ViewHolderDatos(@NonNull View itemView) {

            super(itemView);

            //Le pasamos la referencia del xml
                this.imgProtectora = itemView.findViewById(R.id.imgProtectora);
                this.name = itemView.findViewById(R.id.nameBlog);
                this.number= itemView.findViewById(R.id.descriptionBlog);
                this.direction = itemView.findViewById(R.id.directionProtectora);
                this.cd = itemView.findViewById(R.id.cdProtectora);
                this.website = itemView.findViewById(R.id.websiteProtectora);



        }

    }
}