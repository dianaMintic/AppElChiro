package com.example.elchirostore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.elchirostore.BD.MySQLiteHelper;

public class Registro extends AppCompatActivity
{

    private EditText etPhone;
    private EditText etName;
    private EditText etEmail;
    private EditText etAddress;
    private EditText etClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etPhone= findViewById(R.id.phone);
        etName= findViewById(R.id.personname);
        etEmail=findViewById(R.id.email);
        etAddress=findViewById(R.id.address);
        etClave=findViewById(R.id.clave);

    }

    public  void guardarCliente(View view){
        String phone=etPhone.getText().toString();
        String name= etName.getText().toString();
        String email=etEmail.getText().toString();
        String address=etAddress.getText().toString();
        String clave=etClave.getText().toString();

        //definición de la sentenia de insercion de registro de clientes.

        MySQLiteHelper conexionBD = new MySQLiteHelper(this);
        String InsertQuery = "INSERT INTO cliente (telefono, nombre, email, direccion, clave) " +
                "VALUES ('"+phone+"', '"+name+"', '"+email+"', '"+address+"', '"+clave+"' )";
        conexionBD.inserdata(InsertQuery);


    }

    public void goToMainActivity (View view){
        Intent intentMainActivity = new Intent(this, MainActivity.class);
        startActivity(intentMainActivity);
    }

    public void goToIngreso (View view){
        Intent intentIngreso = new Intent(this, Ingreso.class);
        startActivity(intentIngreso);
    }
}