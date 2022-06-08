package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class individualBlog extends AppCompatActivity implements View.OnClickListener {
    private Drawable blogImg;
    private TextView blogTitle , title_coment, description_coment;
    private TextView blogDescription;
    private Blogs blogs;
    private Blog blog;
    private Button btnAddComent, btnCancelComent;
    private RecyclerView recyclerViewComent;
    private List<Coment> comentList;
    private EditText comentTitle, comentDescription;
    private AdapterComent adapterComent;
    private RecyclerView RecyclerViewComent;
    private FirebaseDatabase db =FirebaseDatabase.getInstance();
    private DatabaseReference root2 = db.getReference().child("blogs");

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

        if(extras==null){
            finish();
            return;
        }

        //Drawable img= extras.getParcelable("img");
        String title= extras.getString("title");
        String description = extras.getString("description");
        String title_coment= extras.getString("title_coment");
        String description_coment = extras.getString("description_coment");

        comentList.add(new Coment(title_coment, description_coment));
        //blog = new Blog(title,description);

        blogTitle=findViewById(R.id.blogTitle);
        blogDescription=findViewById(R.id.blogDescription);




        blogTitle.setText(title);
        blogDescription.setText(description);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAddComent:
                if (comentTitle.getText().toString().isEmpty() || comentDescription.getText().toString().isEmpty()){
                    Toast.makeText(individualBlog.this,"No puedes subir un comentario sin título o sin descripión",Toast.LENGTH_LONG).show();

                    break;
                }else {

                 insert();

/*                    String title = comentTitle.getText().toString();
                    String description =comentDescription.getText().toString();
                    comentList.add(new Coment(title, description));
                    Collections.reverse(comentList);
                    refrescarLsita();
                    comentTitle.setText("");
                    comentDescription.setText("");*/
                }
                break;
            case R.id.btnCancelComent:
                comentTitle.setText("");
                comentDescription.setText("");

        }
    }
    public void refrescarLsita(){
        if (adapterComent==null)return;
        adapterComent.setComentList(comentList);
        adapterComent.notifyDataSetChanged();
    }


    private void insert(){
        Map<String, Object> map=new HashMap<>();
        map.put("title_coment", comentTitle.getText().toString().trim());
        map.put("description_coment", comentDescription.getText().toString().trim());


        FirebaseDatabase.getInstance().getReference().child("blogs").push().setValue(map)
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
                })
        ;

    }


}