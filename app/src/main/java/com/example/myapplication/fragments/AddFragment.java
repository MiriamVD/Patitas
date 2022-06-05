package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;



public class AddFragment extends Fragment {
    private Button btnPublicar, btnBuscar1, btnBuscar2, btnBuscar3, btnBuscar4, btnBuscar5;
    private EditText etContactPerson, etPhone, etEmail,etDescription;

public AddFragment(){

}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);




    }
}