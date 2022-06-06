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
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        btnFloat=findViewById(R.id.btnFloatHome);
        btnFloat.setOnClickListener((View.OnClickListener)this);

        listaProtectora= new ArrayList<>();
        listaProtectora.add(new Protectora(getResources().getDrawable(R.drawable.zarpas_y_colmillos),"Zarpas y colmillos",
                "987987987",
                "calle ni idea",
                "CP: 64789",
                "https://www.zarpasycolmillos.es/"));
        listaProtectora.add(new Protectora(getResources().getDrawable(R.drawable.cipar),"CIPAR",
                "987987987",
                "calle ni idea",
                "CP: 64789",
                "https://www.facebook.com/centroCIPAR/"));
        listaProtectora.add(new Protectora(getResources().getDrawable(R.drawable.ascan),"ASCAN",
                "987987987",
                "calle ni idea",

                "CP: 64789",
                "https://ascan.com.es/"));
        listaProtectora.add(new Protectora(getResources().getDrawable(R.drawable.fapam),"F.A.P.A.M.",
                "987987987",
                "calle ni idea",
                "CP: 64789",
                "https://fapam.org/"));
        listaProtectora.add(new Protectora(getResources().getDrawable(R.drawable.apac),"APAC",
                "987987987",
                "calle ni idea",
                "CP: 64789",
                "https://www.facebook.com/apac.ciempozuelos.9"));
        listaProtectora.add(new Protectora(getResources().getDrawable(R.drawable.palevlas),"PALEVLAS",
                "987987987",
                "calle ni idea",
                "CP: 64789",
                "https://palevlasprotectora.es/"));
        listaProtectora.add(new Protectora(getResources().getDrawable(R.drawable.spap),"S.P.A.P",
                "913119133",
                "calle ni idea",
                "CP: 64789",
                "http://www.spap.net/"));


            adapter = new Adapter(listaProtectora);



        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFloatHome:
                Intent returned= new Intent(Protectoras.this, MainActivity.class);
                startActivity(returned);
                break;
    }}
}