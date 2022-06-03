package com.example.myapplication;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


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

        View lista_cervezas= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lista_protectoras,viewGroup,false);
        return new ViewHolderDatos(lista_cervezas);
    }

    @Override
    //Encargado de actualizar los datos de un ViewHolder ya existente.
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int i) {


        //obtenemos la cerveza de nuestra lista gracias al indice i
        Protectora protectora =listaProtectora.get(i);
        //obtenemos los datos de la lista
        Image img = protectora.getImgProtectora();
        String name = protectora.getNameProtectora();

        String number =protectora.getNumberProtectora();
        //ponemos a los textview los datos con settext
       // holder.img.setImgage()
        //holder.img.setImage();
        holder.name.setText("hola");
        holder.description.setText("lorem impsu dolor sit amet");
        holder.number.setText("lorem");

    }

    @Override
    //obtenemos la cantidad de items
    public int getItemCount() {

        return listaProtectora.size();
    }

    class ViewHolderDatos extends RecyclerView.ViewHolder {
        View img;
        TextView name, description, number;

        ViewHolderDatos(@NonNull View itemView) {

            super(itemView);
            this.img= itemView.findViewById(R.id.imgProtectora);
            //Le pasamos la referencia del xml
            this.name = itemView.findViewById(R.id.nameProtectora);
            this.description= itemView.findViewById(R.id.numberProtectora);
            this.number = itemView.findViewById(R.id.directionProtectora);

        }

    }
}