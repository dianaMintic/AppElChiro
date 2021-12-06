package com.example.elchirostore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.elchirostore.BD.MySQLiteHelper;

public class Ingreso extends AppCompatActivity {

    private EditText etPhone;
    private EditText etClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);

        etPhone= findViewById(R.id.Phone);
        etClave= findViewById(R.id.clave_log);

    }

    public  void validarCliente(View view){
        String phone=etPhone.getText().toString();
        String clave=etClave.getText().toString();

        //definición de la sentenia de insercion de registro de clientes.

        MySQLiteHelper conexionBD = new MySQLiteHelper(this);
        String InsertQuery = "SELECT * FROM cliente WHERE telefono = +" phone;
        boolean success = conexionBD.inserdata(InsertQuery);
        if (success){
            Toast.makeText(this, "Estas registrado.", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Cliente no Registrado.", Toast.LENGTH_LONG).show();
        }
    }

    public void goToMainActivity (View view){
        Intent intentMainActivity = new Intent(this, MainActivity.class);
        startActivity(intentMainActivity);
    }

    public void goToBusqueda (View view){
        Intent intentBusqueda = new Intent(this, Busqueda.class);
        startActivity(intentBusqueda);
    }
}