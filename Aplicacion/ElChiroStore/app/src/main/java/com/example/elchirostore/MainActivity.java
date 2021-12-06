package com.example.elchirostore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.elchirostore.BD.MySQLiteHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MySQLiteHelper conexionBD = new MySQLiteHelper(this);
    }

    public void goToIngreso (View view){
        Intent intentIngreso = new Intent(this, Ingreso.class);
        startActivity(intentIngreso);
    }

    public void goToMarcas (View view){
        Intent intentMarcas = new Intent(this, Marcas.class);
        startActivity(intentMarcas);
    }

    public void goToRegistro (View view){
        Intent intentRegistro = new Intent(this, Registro.class);
        startActivity(intentRegistro);
    }
}