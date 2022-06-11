package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IndividualPet extends AppCompatActivity {
    private TextView petName,petStatus, petType, phonePerson, contactPerson, emailPerson, petDescription, petStreet, petCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_pet);

        petName = findViewById(R.id.petName);
        petStatus =findViewById(R.id.petStatus);
        petType = findViewById(R.id.petType);
        phonePerson = findViewById(R.id.phone);
        contactPerson= findViewById(R.id.contactPerson);
        emailPerson = findViewById(R.id.email);
        petDescription= findViewById(R.id.description);
        petStreet=findViewById(R.id.tvStreet);
        petCity=findViewById(R.id.tvCity);

        Bundle extras= getIntent().getExtras();

        if(extras==null){
            finish();
            return;
        }

        //Drawable img= extras.getParcelable("img");
        String name= extras.getString("name");
        String status = extras.getString("status");
        String type= extras.getString("type");
        String phone = extras.getString("phone");
        String contact = extras.getString("contact");
        String email = extras.getString("email");
        String description = extras.getString("description");
        String city=extras.getString("city");
        String street =extras.getString("street");


        petName.setText(name);
        petStatus.setText(status);
        petType.setText(type);
        phonePerson.setText(phone);
        contactPerson.setText(contact);
        emailPerson.setText(email);
        petDescription.setText(description);
        petStreet.setText(street);
        petCity.setText(city);
    }
}