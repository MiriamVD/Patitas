package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.models.Pet;
import com.example.myapplication.models.Protectora;

import java.util.ArrayList;
import java.util.List;

public class AdapterPets extends RecyclerView.Adapter<AdapterPets.ViewHolderDatos>{
    private List<Pet> petsList;
    ArrayList<Pet> listaOriginal;
    Context context;

    public void setPetsList(List<Pet> petsList ){
        this.petsList=petsList;
    }
    public AdapterPets(Context context, ArrayList<Pet> pet){
        this.context=context;
        this.petsList=pet;
        listaOriginal=new ArrayList<>();
        listaOriginal.addAll(petsList);
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view_pet_single= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_pet_single, viewGroup, false);

        return new ViewHolderDatos(view_pet_single);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        Pet pet = petsList.get(position);

        String petName = pet.getPetName();
        String selectedStatus=pet.getSelectedStatus();
        String selectedType=pet.getSelectedType();
        String contactPerson=pet.getContactPerson();
        String phone = pet.getPhone();
        String email=pet.getEmail();

        holder.petName.setText(petName);
        holder.petStatus.setText(selectedStatus);
        holder.petType.setText(selectedType);
        holder.contactPerson.setText(contactPerson);
        holder.phone.setText(phone);
        holder.email.setText(email);

    }


    @Override
    public int getItemCount() {
        return petsList.size();
    }
    class  ViewHolderDatos extends  RecyclerView.ViewHolder{
        TextView petName, petStatus, petType, contactPerson, phone, email;

        ViewHolderDatos(@NonNull View itemView){
            super(itemView);
            this.petName = itemView.findViewById(R.id.petName);
            this.petStatus= itemView.findViewById(R.id.petStatus);
            this.petType = itemView.findViewById(R.id.petType);
            this.contactPerson = itemView.findViewById(R.id.contactPerson);
            this.phone = itemView.findViewById(R.id.phone);
            this.email = itemView.findViewById(R.id.email);
        }
    }
}