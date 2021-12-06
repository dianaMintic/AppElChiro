package com.example.elchirostore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.elchirostore.BD.MySQLiteHelper;

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


    public void showCategorias(){
        Integer id;
        String nombre;
        Integer total;
        MySQLiteHelper conexion_bd = new MySQLiteHelper(this);
        String sentence ="SELECT * FROM categoria";
        Cursor resultados = conexion_bd.getData(sentence,null);
        try {
            resultados.moveToPosition(0);
            do {
                id = resultados.getInt(0);
                nombre = resultados.getString(1);
                total = resultados.getCount();
                Toast.makeText(this, id + "-" + nombre + "-" + total, Toast.LENGTH_LONG).show();
            }while (resultados.moveToNext());
        }catch (Exception e){
            Toast.makeText(this, "Error al ejecutar la consulta", Toast.LENGTH_LONG).show();
        }finally {
            resultados.close();
        }
    }
}