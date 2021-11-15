package com.example.elchirostore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Categorias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
    }
    public void goToBusqueda (View view){
        Intent intentBusqueda = new Intent(this, Busqueda.class);
        startActivity(intentBusqueda);
    }
    public void goToResumenPedido (View view){
        Intent intentResumenPedido = new Intent(this, ResumenPedido.class);
        startActivity(intentResumenPedido);
    }
}