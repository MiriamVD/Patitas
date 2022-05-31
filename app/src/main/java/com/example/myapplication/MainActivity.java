package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

private Button btn_Protectoras;
private Button btn_Encuentra;
private Button btn_Blog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Protectoras=findViewById(R.id.btn_Blog);
        btn_Encuentra=findViewById(R.id.btn_Encuentra);
        btn_Blog=findViewById(R.id.btn_Blog);
    }

    @Override
    public void onClick(View view) {
        switch (btn_Protectoras.getId()) {
            case R.id.btn_Protectoras:
                Intent movimento1= new Intent(MainActivity.this, Protectoras.class);
                startActivity(movimento1);
        }
        switch (btn_Encuentra.getId()) {
            case R.id.btn_Encuentra:
                Intent movimento1= new Intent(MainActivity.this, AnimalesPerdidos.class);
                startActivity(movimento1);
        }
        switch (btn_Blog.getId()) {
            case R.id.btn_Blog:
                Intent movimento1= new Intent(MainActivity.this, Blog.class);
                startActivity(movimento1);
        }

    }
}