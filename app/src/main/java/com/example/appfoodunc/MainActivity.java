package com.example.appfoodunc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_user, et_password;
    Button b_ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_user = findViewById(R.id.et_Usuario);
        et_password = findViewById(R.id.et_Password);
        b_ingresar= findViewById(R.id.b_Ingresar);
        b_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarUsuario();
            }
        });

    }

    private void guardarUsuario() {
        String usu=et_user.getText().toString();
        String pas=et_password.getText().toString();

        if (usu.equals("admin") && pas.equals("admin")){
            if (!existeUsuario()) {
                //creando el archivo xml de sharedpreferences
                SharedPreferences sharedPreferences = getSharedPreferences("usuarios", Context.MODE_PRIVATE);
                SharedPreferences.Editor oEditor = sharedPreferences.edit(); //aca guardaos los datos ingresados directamente
                oEditor.putString("nombre", "Juan Perez");
                oEditor.putString("usuario", "admin");
                oEditor.putInt("estado", 1);
                oEditor.apply();
                //
            }
            Intent oIntent=new Intent(this, ActivityInicio.class);
            startActivity(oIntent);
            this.finish();
        }else
            Toast.makeText(this, "Usuario o clave incorrecta", Toast.LENGTH_SHORT).show();
    }

    private boolean existeUsuario() {
        boolean usu=false;
        SharedPreferences sharedPreferences=getSharedPreferences("usuarios",Context.MODE_PRIVATE);
        String usuario=sharedPreferences.getString("usuario","");
        if (usuario.equals("jperez")){
            usu=true;
        }
        return usu;
    }


}