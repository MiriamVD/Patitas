package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final String CREATETABLE= "CREATE TABLE mascotas" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL, telefono INTEGER NOT NULL, email TEXT NOT NULL, description TEXT NOT NULL) ";
    private static final String NOMBRE_BD = "animales_protegidos_db";


    private static final int versionBD = 1;
    private final Context contexto;



    public DbHelper(Context contexto) {
        super(contexto, NOMBRE_BD, null, versionBD);
        this.contexto=contexto;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATETABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
