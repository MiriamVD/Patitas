package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Protectoras extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton btnFloat;
    private RecyclerView recyclerView;
    private Adapter adapter;
    private List<Protectora> listaProtectora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protectoras);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        btnFloat=findViewById(R.id.btnFloat);
        btnFloat.setOnClickListener((View.OnClickListener)this);

        listaProtectora= new ArrayList<>();
        listaProtectora.add(new Protectora("Zarpas y colmillos",
                " 987987987",
                "calle ni idea",
                "64789",
                "http:sfsoefso/dfsf"));
        listaProtectora.add(new Protectora("hola",
                " 987987987",
                "calle ni idea",
                "64789",
                "http:sfsoefso/dfsf"));
        listaProtectora.add(new Protectora("adios",
                " 987987987",
                "calle ni idea",
                "64789",
                "http:sfsoefso/dfsf"));
        for(int i=0;i<listaProtectora.size();i++){
            adapter = new Adapter(listaProtectora);
        }


        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFloat:
                Intent returned= new Intent(Protectoras.this, MainActivity.class);
                startActivity(returned);
                break;
    }}
}