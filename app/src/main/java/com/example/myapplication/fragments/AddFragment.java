package com.example.myapplication.fragments;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;


public class AddFragment extends Fragment  {
    private static final int RESULT_OK = 200;
    private Button btnPublicar;
    private ImageView btnBuscar1, btnBuscar2, btnBuscar3, btnBuscar4, btnBuscar5, btnLocation;
    private EditText etPetName,etContactPerson, etPhone, etEmail,etDescription, etStreet, etCity;
    private Spinner spinnerStatus, spinnerType;

    private StorageReference storageReference;
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference().child("pets");
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";



public AddFragment(){

}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
       return inflater.inflate(R.layout.fragment_add, container, false);
     
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
    super.onViewCreated(view, savedInstanceState);



        btnPublicar=view.findViewById(R.id.btnPublicar);
        btnBuscar1=view.findViewById(R.id.btnBuscar1);
        btnBuscar2=view.findViewById(R.id.btnBuscar2);
        btnBuscar3=view.findViewById(R.id.btnBuscar3);
        btnBuscar4=view.findViewById(R.id.btnBuscar4);
        btnBuscar5=view.findViewById(R.id.btnBuscar5);

        etPetName=view.findViewById(R.id.etPetName);
        etContactPerson=view.findViewById(R.id.etContactPerson);
        etPhone=view.findViewById(R.id.etPhone);
        etEmail=view.findViewById(R.id.etEmail);
        etDescription=view.findViewById(R.id.etDescription);
        etStreet=view.findViewById(R.id.etStreet);
        etCity=view.findViewById(R.id.etCity);

        spinnerStatus=view.findViewById(R.id.spinnerStatus);
        spinnerType=view.findViewById(R.id.spinnerType);










        btnPublicar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String selectedStatus=spinnerStatus.getSelectedItem().toString().trim();
                String selectedType=spinnerType.getSelectedItem().toString().trim();
                String addPetName=etPetName.getText().toString().trim();
                String addPhone=etPhone.getText().toString().trim();
                String addContactPerson=etContactPerson.getText().toString().trim();
                String addEmail=etEmail.getText().toString().trim();
                String addDescription=etDescription.getText().toString().trim();
                //String addStreet=etStreet.getText().toString().trim();
                String addCity=etCity.getText().toString().trim();



            if(spinnerStatus.getSelectedItemPosition()==0 || spinnerType.getSelectedItemPosition()==0){
                Toast.makeText(getActivity(),"Debes seleccionar las opciones", Toast.LENGTH_SHORT).show();
            }else{
                if(addPetName.isEmpty() && addPhone.isEmpty() && addContactPerson.isEmpty() &&addEmail.isEmpty()
                        && addDescription.isEmpty () && addCity.isEmpty()){
                    Toast.makeText(getActivity(),"Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
                }else if((addPhone.length()!=9) || (addPhone.charAt(0)!='6' &&  addPhone.charAt(0)!='7' && addPhone.charAt(0)!='8' && addPhone.charAt(0)!='9' ))

{
                    Toast.makeText(getActivity().getApplicationContext(), "Debes introducir un número válido", Toast.LENGTH_SHORT).show();
                }else if(addEmail.matches(emailPattern)==false){
                    Toast.makeText(getActivity(), "Debes introducir un mail válido", Toast.LENGTH_SHORT).show();

                } else{
                    insert();


                }
            }

            }

        });
        btnBuscar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openCamera();
               /** try {
                    Intent intent = new Intent();
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);

                }catch (Exception e){
                    e.printStackTrace();
                }*/



               /**boolean pick =true;
               if(pick==true){
                   if(!checkCameraPermission()){
                       requestCameraPermission();


               }else
                   PickImage();

               }else{
                   if(!checkStoragePermission()){
                       requestStoragePermission();
                   }else{
                       PickImage();
                   }
                }*/


            }




        });

    }

    /**private void getLocation() {

        if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getContext(), "Tenemos permiso", Toast.LENGTH_LONG).show();
        }else{
            ActivityCompat.requestPermissions(getContext(), new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION}, Manifest.permission.ACCESS_FINE_LOCATION, 1);
            }
        }
    }*/

    private void openCamera(){
    Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if(intent.resolveActivity(getActivity().getPackageManager())!=null){
        startActivityForResult(intent, 1);

    }

}
/**public void onActivityResult(int requestCode, int resultCode, Intent data){
    super.onActivityResult(requestCode,resultCode,data);
    if(requestCode==1 && resultCode == RESULT_OK){
        Bundle extras = data.getExtras();
        Bitmap imgBitmap =(Bitmap) extras.get("data");
    }

}*/

    private void insert(){
    Map<String, Object> map=new HashMap<>();
    map.put("petName", etPetName.getText().toString().trim());
    map.put("phone", etPhone.getText().toString().trim());
    map.put("contactPerson", etContactPerson.getText().toString().trim());
    map.put("email", etEmail.getText().toString().trim());
    map.put("description", etDescription.getText().toString().trim());
    map.put("selectedStatus",spinnerStatus.getSelectedItem().toString().trim());
    map.put("selectedType",spinnerType.getSelectedItem().toString().trim());
    map.put("street", etStreet.getText().toString().trim());
    map.put("city", etCity.getText().toString().trim());


        FirebaseDatabase.getInstance().getReference().child("pets").push().setValue(map)
            .addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void avoid) {
                    etPetName.setText("");
                    etPhone.setText("");
                    etContactPerson.setText("");
                    etEmail.setText("");
                    etDescription.setText("");
                    etStreet.setText("");
                    etCity.setText("");
                    Toast.makeText(getContext(), "Insertado correctamente", Toast.LENGTH_LONG).show();


                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getContext(), "Error insertando los datos", Toast.LENGTH_LONG).show();


                }
            })
    ;

    }




    /**private boolean checkCameraPermission() {
        boolean res1= ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)==pm.PERMISSION_GRANTED;
        boolean res2= ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)==pm.PERMISSION_GRANTED;
        return res1 && res2;
    }
    private boolean checkStoragePermission() {
        boolean res2= ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)==pm.PERMISSION_GRANTED;
        return res2;

    }
    private void requestCameraPermission() {
    requestPermissions(new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
    }
    private void requestStoragePermission() {
        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);


    }
    private void PickImage() {
        CropImage.activity(image_url)
                .setGuidelines(CropImageView.Guidelines.ON)
                .start((Activity) getActivity().getApplicationContext());

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
    if(requestCode==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
        CropImage.ActivityResult result=CropImage.getActivityResult(data);
        if(resultCode== RESULT_OK){
            Uri resultUri = result.getUri();
        }else if(resultCode ==CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
            Exception error = result.getError();
        }
    }
    }*/


}