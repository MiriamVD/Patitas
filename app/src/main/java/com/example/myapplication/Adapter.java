package com.example.myapplication;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.models.Protectora;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderDatos> {
    private List<Protectora> listaProtectora;


    public void setListaProtectora(List<Protectora> listaProtectora){
        this.listaProtectora=listaProtectora;
    }

    //genero un constructor

    public Adapter(List<Protectora> protectora) {

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


        //obtenemos la protectora de nuestra lista gracias al indice i
        Protectora protectora =listaProtectora.get(i);
        //obtenemos los datos de la lista
        Drawable img = protectora.getImgProtectora();
        String name = protectora.getNameProtectora();
        String number =protectora.getNumberProtectora();
        String direction = protectora.getDirectionProtectora();
        String cd = protectora.getCdProtectora();
        String website = protectora.getWebsiteProtectora();
        //ponemos a los textview los datos con settext


        holder.img.setBackgroundDrawable(img);
        holder.name.setText(name);
        holder.number.setText(number);
        holder.direction.setText(direction);
        holder.cd.setText(cd);
        holder.website.setText(website);

    }

    @Override
    //obtenemos la cantidad de items
    public int getItemCount() {

        return listaProtectora.size();
    }

    class ViewHolderDatos extends RecyclerView.ViewHolder {
        View img;
        TextView name, number, direction, cd, website ;

        ViewHolderDatos(@NonNull View itemView) {

            super(itemView);
            //this.img= itemView.findViewById(R.id.imgProtectora);
            //Le pasamos la referencia del xml
                this.img = itemView.findViewById(R.id.imgBlog);
                this.name = itemView.findViewById(R.id.nameBlog);
                this.number= itemView.findViewById(R.id.descriptionBlog);
                this.direction = itemView.findViewById(R.id.directionProtectora);
                this.cd = itemView.findViewById(R.id.cdProtectora);
                this.website = itemView.findViewById(R.id.websiteProtectora);



        }

    }
}