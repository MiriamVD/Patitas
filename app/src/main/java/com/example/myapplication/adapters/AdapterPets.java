package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.Blog;
import com.example.myapplication.models.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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
        String description=pet.getDescription();
        String street= pet.getStreet();
        String city= pet.getCity();

        holder.petName.setText(petName);
        holder.petStatus.setText(selectedStatus);
        holder.petType.setText(selectedType);
        holder.contactPerson.setText(contactPerson);
        holder.phone.setText(phone);
        holder.email.setText(email);
        holder.description.setText(description);
        holder.city.setText(city);
        holder.street.setText(street);

    }


    @Override
    public int getItemCount() {
        return petsList.size();
    }

    public void setFilterListPet(List<Pet>filterList) {
        this.petsList =filterList;
        notifyDataSetChanged();
    }

    class  ViewHolderDatos extends  RecyclerView.ViewHolder{
        TextView petName, petStatus, petType, contactPerson, phone, email,description, street, city;

        ViewHolderDatos(@NonNull View itemView){
            super(itemView);
            this.petName = itemView.findViewById(R.id.petName);
            this.petStatus= itemView.findViewById(R.id.petStatus);
            this.petType = itemView.findViewById(R.id.petType);
            this.contactPerson = itemView.findViewById(R.id.contactPerson);
            this.phone = itemView.findViewById(R.id.phone);
            this.email = itemView.findViewById(R.id.email);
            this.description=itemView.findViewById(R.id.description);
            this.city=itemView.findViewById(R.id.tvCity);
            this.street=itemView.findViewById(R.id.tvStreet);
        }
    }
}