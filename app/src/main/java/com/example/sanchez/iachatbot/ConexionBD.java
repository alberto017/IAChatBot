package com.example.sanchez.iachatbot;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ConexionBD extends SQLiteOpenHelper {

    private static final String NOMBRE_BD = "chatbotIA.bd";
    private static final int VERSION_BD = 1;
    private static final String TABLA_PALABRAS = "CREATE TABLE PALABRAS(PALABRA TEXT)";


    public ConexionBD(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase SQLiteDatabase) {
        SQLiteDatabase.execSQL(TABLA_PALABRAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase SQLiteDatabase, int oldVersion, int newVersion) {
        SQLiteDatabase.execSQL("DROP TABLE IF EXISTS'"+TABLA_PALABRAS+"'");
        SQLiteDatabase.execSQL(TABLA_PALABRAS);
    }

    public void agregarPalabra(String palabra){
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            db.execSQL("INSERT INTO PALABRAS VALUES('"+palabra+"')");
            db.close();
        }
    }


    //Este metodo es para cargar los datos
    /*
    public void llenarLista(){
        ListView listado (ListView) findViewById(R.id.listView); //Este componente no existe
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,layout,simple_list_item_1,leerPalabras());
        listado.setAdapter(adapter);
    }
    */


    public String[] leerPalabras(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT PALABRA FROM PALABRAS",null);
        int posicion = 0;
        String[] palabras = new String[cursor.getCount()];
        if(cursor.moveToFirst()){
            do{
                String registro = cursor.getString(0);
                palabras[posicion] = registro;
                posicion++;
            }while(cursor.moveToNext());
        }
        return palabras;
    }
}
