package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.models.Protectora;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyStore.ProtectionParameter;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;

public class Protectoras extends AppCompatActivity implements View.OnClickListener, SearchView.OnQueryTextListener {
    private FloatingActionButton btnFloat;
    private RecyclerView recyclerView;
    private AdapterProtectoras adapter;
    private ArrayList<Protectora> listaProtectora;
    private SearchView searchView;
    private FirebaseDatabase db =FirebaseDatabase.getInstance();
    private DatabaseReference reference = db.getReference().child("protectoras");
    private ImageView imgProtectora;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protectoras);

        recyclerView=findViewById(R.id.recyclerView);
        searchView=findViewById(R.id.search);
        setTitle("Protectoras");
        btnFloat=findViewById(R.id.btnFloatHome);
        btnFloat.setOnClickListener((View.OnClickListener)this);
        searchView();

        /**String imageUri = "https://i.imgur.com/tGbaZCY.jpg";
        ImageView ivBasicImage = (ImageView) findViewById(R.id.imgBlog);
        Picasso.with(Protectoras.this).load(imageUri).into(ivBasicImage);*/

        listaProtectora= new ArrayList<>();

        adapter = new AdapterProtectoras(this, listaProtectora);

        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot ds: snapshot.getChildren() ) {


                    Protectora protectora =ds.getValue(Protectora.class);
                    listaProtectora.add(protectora);
                }
               adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Protectoras.this,"Error:" + error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

        searchView.setOnQueryTextListener(this);

        }

    private void searchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                processSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                processSearch(newText);
                return false;
            }
        });
    }

    public void processSearch(String newText) {




    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFloatHome:
                Intent returned= new Intent(Protectoras.this, MainActivity.class);
                startActivity(returned);
                break;
    }}


    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.filtrado(s);
        return false;
    }
}