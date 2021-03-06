package com.example.myapplication.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.myapplication.adapters.AdapterPets;

import com.example.myapplication.IndividualPet;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.RecyclerTouchListener;
import com.example.myapplication.models.Pet;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ListFragment extends Fragment {
    private FloatingActionButton btnFloat;
    private RecyclerView recyclerView;
    private AdapterPets adapter;
    private ArrayList<Pet> petsList;
    private FirebaseDatabase db =FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("pets");
    private SearchView search;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_list, container, false);

        search = view.findViewById(R.id.search);
        btnFloat =(FloatingActionButton) view.findViewById(R.id.btnFloatHome);
        btnFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });


        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);


        petsList=new ArrayList<>();

        adapter=new AdapterPets( getContext(), petsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot ds: snapshot.getChildren() ) {
                    Pet pet =ds.getValue(Pet.class);
                    petsList.add(pet);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(),recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                //pasar a la actividad PantallaModificar. Le pasamos los datos con el putExtra.
                Pet petSeleccionado = adapter.getList().get(position);
                Intent intent = new Intent(getContext(), IndividualPet.class);
                // intent.putExtra("img", blogSeleccionado.getImgBlog());
                intent.putExtra("name", petSeleccionado.getPetName());
                intent.putExtra("status", petSeleccionado.getSelectedStatus());
                intent.putExtra("type", petSeleccionado.getSelectedType());
                intent.putExtra("phone", petSeleccionado.getPhone());
                intent.putExtra("contact", petSeleccionado.getContactPerson());
                intent.putExtra("email", petSeleccionado.getEmail());
                intent.putExtra("description", petSeleccionado.getDescription());
                intent.putExtra("city", petSeleccionado.getCity());
                intent.putExtra("street", petSeleccionado.getStreet());

                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filtrado(s);
                return true;
            }
        });

    }

    private void filtrado(String s) {
        List<Pet> filterList = new ArrayList<>();
        for (Pet pet: petsList) {
            if (pet.getPetName().toLowerCase().contains(s.toLowerCase())){
                filterList.add(pet);
            }
        }
        if (filterList.isEmpty()){
            Toast.makeText(getContext(), "no hay datos", Toast.LENGTH_SHORT).show();
        }else {
            adapter.setFilterListPet(filterList);
        }
    }






/*    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFloatHome:
                Intent returned = new Intent(getContext(), MainActivity.class);
                startActivity(returned);
                break;
        }
    }*/
}