package com.example.elchirostore;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.elchirostore.BD.MySQLiteHelper;
import com.example.elchirostore.listViews.MarcaListViewAdapter;

import java.util.ArrayList;

public class Marcas extends AppCompatActivity {

    private ArrayList<String> marcalist;
    private ListView listView;
    private static MarcaListViewAdapter adapter;

    public Marcas(String nombre, String descripcion, Object o) {
    }
    //private ListView lvOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcas);
        marcalist = new ArrayList<String>();
        listView = findViewById(R.id.lvone);
        showMarcas();

    }

    public void showMarcas(){
        int id;
        String nombre;
        String descripcion;
        String imagen;

        MySQLiteHelper conexion_bd = new MySQLiteHelper(this);
        String sentence ="SELECT * FROM marca";

        Cursor resultados = conexion_bd.getData(sentence,null);

        try {
            resultados.moveToPosition(0);
            do {
                id = resultados.getInt(0);
                nombre = resultados.getString(1);
                marcalist.add(nombre);
                adapter = new MarcaListViewAdapter(this, marcalist);
                listView.setAdapter(adapter);

            } while (resultados.moveToNext());

        } catch (Exception e){
            Toast.makeText(this, "Error al ejecutar la consulta", Toast.LENGTH_LONG).show();
        } finally {
        resultados.close();
        }
    }

}