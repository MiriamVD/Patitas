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
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication.Controller;
import com.example.myapplication.R;



public class AddFragment extends Fragment {
    private Button btnPublicar, btnBuscar1, btnBuscar2, btnBuscar3, btnBuscar4, btnBuscar5;
    private EditText etContactPerson, etPhone, etEmail,etDescription;
    private Spinner spinnerStatus, spinnerType;
public AddFragment(){

}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       return inflater.inflate(R.layout.fragment_add, container, false);
     
    }
    /**
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
    super.onViewCreated(view, savedInstanceState);
        btnPublicar=view.findViewById(R.id.btnPublicar);
        btnBuscar1=view.findViewById(R.id.btnBuscar1);
        btnBuscar2=view.findViewById(R.id.btnBuscar2);
        btnBuscar3=view.findViewById(R.id.btnBuscar3);
        btnBuscar4=view.findViewById(R.id.btnBuscar4);
        btnBuscar5=view.findViewById(R.id.btnBuscar5);

        etContactPerson=view.findViewById(R.id.etContactPerson);
        etPhone=view.findViewById(R.id.etPhone);
        etEmail=view.findViewById(R.id.etEmail);
        etDescription=view.findViewById(R.id.etDescription);
        spinnerStatus=view.findViewById(R.id.spinnerStatus);
        spinnerType=view.findViewById(R.id.spinnerType);*/
       /** btnPublicar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String selectedStatus=spinnerStatus.getSelectedItem().toString();
                String selectedType=spinnerType.getSelectedItem().toString();
                String addContactPerson=etContactPerson.getText().toString();
                String addPhone=etPhone.getText().toString();
                String addEmail=etEmail.getText().toString();
                String addDescription=etDescription.getText().toString();

                if("".equals(addContactPerson)){
                    etContactPerson.setError("Introduzca un nombre");
                    etContactPerson.requestFocus();


                } if("".equals(addPhone)){
                    etPhone.setError("Introduzca un teléfono");
                    etPhone.requestFocus();
                }if(  "".equals(addEmail)){
                    etEmail.setError("Introduzca un email");
                    etEmail.requestFocus();

                }if("".equals(addDescription)) {
                    etDescription.setError("Introduzca una descripción");
                    etDescription.requestFocus();
                }
            }

        });

    }*/

}