package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.myapplication.adapters.AdapterBlog;
import com.example.myapplication.models.Blog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Blogs extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton btnFloat;
    private RecyclerView recyclerViewBlog;
    private AdapterBlog adapterBlog;
    private ArrayList<Blog> listaBlog;
    private FirebaseDatabase db =FirebaseDatabase.getInstance();
    private DatabaseReference root2 = db.getReference().child("blogs");
    private Context context;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        recyclerViewBlog=findViewById(R.id.recyclerView2);

        setTitle("Blog");
        listaBlog = new ArrayList<>();
        adapterBlog = new AdapterBlog(this,listaBlog);

        searchView=findViewById(R.id.searchBlog);
        btnFloat=findViewById(R.id.btnFloatHome);
        btnFloat.setOnClickListener((View.OnClickListener)this);
        recyclerViewBlog.setAdapter(adapterBlog);
        RecyclerView.LayoutManager mLayoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerViewBlog.setLayoutManager(mLayoutManager);
        recyclerViewBlog.setItemAnimator(new DefaultItemAnimator());

        root2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds: snapshot.getChildren() ) {
                    Blog blog =ds.getValue(Blog.class);
                    listaBlog.add(blog);
                }
                adapterBlog.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Blogs.this,"Error:" + error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
        recyclerViewBlog.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),recyclerViewBlog, new RecyclerTouchListener.ClickListener() {


            @Override
            public void onClick(View view, int position) {
                //pasar a la actividad PantallaModificar. Le pasamos los datos con el putExtra.
                Blog blogSeleccionado = adapterBlog.getList().get(position);

                Intent intent = new Intent(Blogs.this, IndividualBlog.class);
                intent.putExtra("image", blogSeleccionado.getImage());
                intent.putExtra("blogkey", blogSeleccionado.getblogkey());
                intent.putExtra("title", blogSeleccionado.gettitle());
                intent.putExtra("description", blogSeleccionado.getdescription());
                intent.putExtra("blogkey", blogSeleccionado.getblogkey());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        List<Blog> filterList= new ArrayList<>();
        for (Blog blog: listaBlog) {
            if(blog.gettitle().toLowerCase().contains(s.toLowerCase())){
                filterList.add(blog);
            }
        }
        if(filterList.isEmpty()){
            Toast.makeText(this, "no hay datos", Toast.LENGTH_SHORT).show();
        }else {
            adapterBlog.setFilterList(filterList);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFloatHome:
                Intent returned= new Intent(Blogs.this, MainActivity.class);
                startActivity(returned);
                break;
    }
}


}