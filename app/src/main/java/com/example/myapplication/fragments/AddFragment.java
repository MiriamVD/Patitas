package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class AddFragment extends Fragment {
    private Button btnPublicar;
    private ImageView btnBuscar1, btnBuscar2, btnBuscar3, btnBuscar4, btnBuscar5;
    private EditText etPetName,etContactPerson, etPhone, etEmail,etDescription;
    private Spinner spinnerStatus, spinnerType;






public AddFragment(){

}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
       return inflater.inflate(R.layout.fragment_add, container, false);
     
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
    super.onViewCreated(view, savedInstanceState);

        btnPublicar=view.findViewById(R.id.btnPublicar);
        btnBuscar1=view.findViewById(R.id.btnBuscar1);
        btnBuscar2=view.findViewById(R.id.btnBuscar2);
        btnBuscar3=view.findViewById(R.id.btnBuscar3);
        btnBuscar4=view.findViewById(R.id.btnBuscar4);
        btnBuscar5=view.findViewById(R.id.btnBuscar5);

        etPetName=view.findViewById(R.id.etPetName);
        etContactPerson=view.findViewById(R.id.etContactPerson);
        etPhone=view.findViewById(R.id.etPhone);
        etEmail=view.findViewById(R.id.etEmail);
        etDescription=view.findViewById(R.id.etDescription);
        spinnerStatus=view.findViewById(R.id.spinnerStatus);
        spinnerType=view.findViewById(R.id.spinnerType);

        btnPublicar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String selectedStatus=spinnerStatus.getSelectedItem().toString().trim();
                String selectedType=spinnerType.getSelectedItem().toString().trim();
                String addPetName=etPetName.getText().toString().trim();
                String addPhone=etPhone.getText().toString().trim();
                String addContactPerson=etContactPerson.getText().toString().trim();
                String addEmail=etEmail.getText().toString().trim();
                String addDescription=etDescription.getText().toString().trim();


               if(addPetName.isEmpty() && addPhone.isEmpty() && addContactPerson.isEmpty() &&addEmail.isEmpty()
               && addDescription.isEmpty() ){
                   Toast.makeText(getActivity(),"Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
               }else{
                   insert();

               }
            }

        });

    }

   private void insert(){
    Map<String, Object> map=new HashMap<>();
    map.put("petName", etPetName.getText().toString().trim());
    map.put("phone", etPhone.getText().toString().trim());
    map.put("contactPerson", etContactPerson.getText().toString().trim());
    map.put("email", etEmail.getText().toString().trim());
    map.put("description", etDescription.getText().toString().trim());
    //map.put("selectedStatus",spinnerStatus.getSelectedItem().toString().trim());
   // map.put("selectedType",spinnerType.getSelectedItem().toString().trim());

    FirebaseDatabase.getInstance().getReference().child("pets").push().setValue(map)
            .addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void avoid) {
                    etPetName.setText("");
                    etPhone.setText("");
                    etContactPerson.setText("");
                    etEmail.setText("");
                    etDescription.setText("");
                    Toast.makeText(getContext(), "Insertado correctamente", Toast.LENGTH_LONG).show();


                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getContext(), "Error insertando los datos", Toast.LENGTH_LONG).show();


                }
            })
    ;

    }

}