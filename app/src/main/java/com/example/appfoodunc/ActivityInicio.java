package com.example.appfoodunc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class ActivityInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toast.makeText(this, "Bienvenido "+leerUsuario(), Toast.LENGTH_SHORT).show();


    }





    private String leerUsuario() {
        SharedPreferences sharedPreferences=getSharedPreferences("usuarios", Context.MODE_PRIVATE);
        String nombre=sharedPreferences.getString("nombre","");
        return nombre;
    }
}