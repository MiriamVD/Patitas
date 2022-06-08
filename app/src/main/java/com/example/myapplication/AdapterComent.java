package com.example.myapplication;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.myapplication.models.Coment;

public class AdapterComent extends RecyclerView.Adapter<AdapterComent.ViewHolderDatos> {
    private List<Coment> comentList;
    public void setComentList(List<Coment> comentList){
        this.comentList=comentList;
    }

    //genero un constructor

    public AdapterComent(List<Coment> comentList) {

        this.comentList = comentList;
    }

    @NonNull
    @Override
    public AdapterComent.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View lista_comentarios= LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_comentarios,parent,false);
        return new AdapterComent.ViewHolderDatos(lista_comentarios);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        Coment coment =comentList.get(position);
        //obtenemos los datos de la lista
        String title = coment.gettitle_ccoment();
        String description =coment.getdescription_coment();

        //ponemos a los textview los datos con settext

        holder.title.setText(title);
        holder.description.setText(description);
    }

    @Override
    public int getItemCount() {
        return comentList.size();
    }
    class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView title, description;

        ViewHolderDatos(@NonNull View itemView) {

            super(itemView);
            //Le pasamos la referencia del xml

            this.title = itemView.findViewById(R.id.comentTitle);
            this.description = itemView.findViewById(R.id.comentDescription);


        }
    }
}
