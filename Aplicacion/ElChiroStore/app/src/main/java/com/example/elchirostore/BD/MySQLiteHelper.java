package com.example.elchirostore.BD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String BD_NAME = "chiro_store_db.sqlite";
    private static final Integer BD_VERSION = 1;
    private static final String CLIENTE_TABLE_CREATE = "CREATE TABLE cliente(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                        "telefono TEXT, nombre TEXT, email TEXT, direccion TEXT, clave TEXT )";
    private static final String MARCA_TABLE_CREATE = "CREATE TABLE marca(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                        "nombre TEXT,  descripcion TEXT, imagen TEXT )";
    private static final String CATEGORIA_TABLE_CREATE = "CREATE TABLE categoria(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                        "nombre TEXT, descripcion TEXT, IMAGEN TEXT )";
    private static final String PRODUCTO_TABLE_CREATE = "CREATE TABLE producto(sku INTEGER PRIMARY KEY ," +
                                                        "nombre TEXT, id_categoria TEXT , id_marca TEXT, valor_unidad TEXT, imagen TEXT)";
    private static final String CARRO_TABLE_CREATE = "CREATE TABLE carro(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                     "id_cliente INTEGER, id_producto INTEGER, cantidad INTEGER, valor_unidad INTEGER)";
    private static final String PEDIDO_PRODUCTO_TABLE_CREATE = "CREATE TABLE pedido_producto(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                      "id_producto INTEGER, id_pedido INTEGER, cantidad INTEGER, valor_unidad INTEGER, subtotal INTEGER)";
    private static final String PEDIDO_TABLE_CREATE = "CREATE TABLE pedido(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                        "fecha DATE, id_cliente TEXT, total INTEGER)";


    public MySQLiteHelper(Context context) {
        super(context, BD_NAME, null, BD_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CLIENTE_TABLE_CREATE);
        db.execSQL(MARCA_TABLE_CREATE);
        db.execSQL(CATEGORIA_TABLE_CREATE);
        db.execSQL(PRODUCTO_TABLE_CREATE);
        db.execSQL(CARRO_TABLE_CREATE);
        db.execSQL(PEDIDO_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public boolean inserdata(String sentence){
        boolean success = false;
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(sentence);
            success = true;
        }catch (Exception e){
            success = false;
        }
        return success;
    }

    public Cursor getData(String sentence, String[] params){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cu = db.rawQuery(sentence, params);
        return cu;
    }
}

