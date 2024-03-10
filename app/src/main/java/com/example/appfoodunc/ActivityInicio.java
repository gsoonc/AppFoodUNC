package com.example.appfoodunc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ActivityInicio extends AppCompatActivity {


    BottomNavigationView bnv_inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toast.makeText(this, "Bienvenido "+leerUsuario(), Toast.LENGTH_SHORT).show();


        bnv_inicio.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.inicio) {
                    // Respond to navigation item 1 click
                    return true;
                } else if (itemId == R.id.search) {
                    // Respond to navigation item 2 click
                    return true;
                } else if (itemId == R.id.comidas) {
                    // Respond to navigation item 3 click
                    return true;
                } else if (itemId == R.id.perfil) {
                    // Respond to navigation item 4 click
                    return true;
                } else {
                    return false;
                }


            }
        });

    }





    private String leerUsuario() {
        SharedPreferences sharedPreferences=getSharedPreferences("usuarios", Context.MODE_PRIVATE);
        String nombre=sharedPreferences.getString("nombre","");
        return nombre;
    }
}