package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.adapters.AdapterComent;
import com.example.myapplication.models.Blog;
import com.example.myapplication.models.Coment;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndividualBlog extends AppCompatActivity implements View.OnClickListener {
    private ImageView blogImg;
    private TextView blogTitle , title_coment, description_coment;
    private TextView blogDescription;
    private Blogs blogs;
    private Coment coment;
    private Blog blog;
    private Button btnAddComent, btnCancelComent;
    private RecyclerView recyclerViewComent;
    private List<Coment> comentList;
    private EditText comentTitle, comentDescription;
    private AdapterComent adapterComent;
    private RecyclerView RecyclerViewComent;
    private FirebaseDatabase db =FirebaseDatabase.getInstance();
    private DatabaseReference root2 = db.getReference().child("blogs");
    private List<Blog> blogList;
    String blogkey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        blog= new Blog();
        blogs = new Blogs();
        setContentView(R.layout.activity_individual_blog);
        recyclerViewComent=findViewById(R.id.recyclerView3);

        comentList = new ArrayList<>();
        adapterComent = new AdapterComent(comentList);
        comentTitle = findViewById(R.id.comentTitlex);
        comentDescription = findViewById(R.id.x);
        btnAddComent = findViewById(R.id.btnAddComent);
        btnCancelComent = findViewById(R.id.btnCancelComent);

        recyclerViewComent.setAdapter(adapterComent);
        RecyclerView.LayoutManager mLayoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerViewComent.setLayoutManager(mLayoutManager);
        recyclerViewComent.setItemAnimator(new DefaultItemAnimator());

        Bundle extras= getIntent().getExtras();
        blogkey= extras.getString("blogkey");
        root2.child(blogkey).child("coment").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                    comentList.clear();
                for (DataSnapshot ds: snapshot.getChildren()) {

                    Coment coment = ds.getValue(Coment.class);
                    comentList.add(coment);
                }
                adapterComent.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(IndividualBlog.this,"Error:" + error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });


        if(extras==null){
            finish();
            return;
        }
        blogImg=findViewById(R.id.blogImg);
        String image = extras.getString("image");
        Glide.with(this).load(image).into(blogImg);

        String title= extras.getString("title");
        String description = extras.getString("description");

        blogTitle=findViewById(R.id.blogTitle);
        blogDescription=findViewById(R.id.blogDescription);

        blogImg.setImageResource(R.drawable.logo);
        blogTitle.setText(title);
        blogDescription.setText(description);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAddComent:
                if (comentTitle.getText().toString().isEmpty() || comentDescription.getText().toString().isEmpty()){
                    Toast.makeText(IndividualBlog.this,"No puedes subir un comentario sin título o sin descripión",Toast.LENGTH_LONG).show();

                    break;
                }else {
                insert();
                }
                break;
            case R.id.btnCancelComent:
                comentTitle.setText("");
                comentDescription.setText("");

        }
    }

    private void insert(){
        
        Map<String, Object> coment=new HashMap<>();
        coment.put("title_coment", comentTitle.getText().toString().trim());
        coment.put("description_coment", comentDescription.getText().toString().trim());

        root2.child(blogkey).child("coment").push().setValue(coment)

                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void avoid) {

                        comentTitle.setText("");
                        comentDescription.setText("");


                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {



                    }
                });

    }


}