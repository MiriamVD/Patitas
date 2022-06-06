package com.example.myapplication.fragments;

import android.os.Bundle;

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
        View root= inflater.inflate(R.layout.fragment_add, container, false);

        btnPublicar=root.findViewById(R.id.btnPublicar);
        btnBuscar1=root.findViewById(R.id.btnBuscar1);
        btnBuscar2=root.findViewById(R.id.btnBuscar2);
        btnBuscar3=root.findViewById(R.id.btnBuscar3);
        btnBuscar4=root.findViewById(R.id.btnBuscar4);
        btnBuscar5=root.findViewById(R.id.btnBuscar5);

        etContactPerson=root.findViewById(R.id.etContactPerson);
        etPhone=root.findViewById(R.id.etPhone);
        etEmail=root.findViewById(R.id.etEmail);
        etDescription=root.findViewById(R.id.etDescription);
        spinnerStatus=root.findViewById(R.id.spinnerStatus);
        spinnerType=root.findViewById(R.id.spinnerType);


        btnPublicar.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            String selectedStatus=spinnerStatus.getSelectedItem().toString();
            String selectedType=spinnerType.getSelectedItem().toString();
            String addContactPerson=etContactPerson.getText().toString();
            String addPhone=etPhone.getText().toString();
            String addEmail=etEmail.getText().toString();
            String addDescription=etDescription.getText().toString();

            if(selectedStatus !="Mascota" &&selectedType !="Tipo"){
                if(addContactPerson != "" && addPhone !="" && addEmail != "" && addDescription != ""){

                }
            }
        }
    });





        return root;
    }

}