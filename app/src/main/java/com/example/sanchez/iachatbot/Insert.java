package com.example.sanchez.iachatbot;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insert extends AppCompatActivity {

    EditText txtPalabra;
    Button btnAgregar;
    Button btnLimpiar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        txtPalabra = findViewById(R.id.txtPalabra);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnLimpiar = findViewById(R.id.btnLimpiar);

        final ConexionBD conexionBD = new ConexionBD(getApplicationContext());

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conexionBD.agregarPalabra(txtPalabra.getText().toString());
                Toast.makeText(getApplicationContext(),"Palabra agregada correctamente",Toast.LENGTH_LONG).show();
                txtPalabra.setText("");
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            Intent intent2 = new Intent(Insert.this,Words.class);
            startActivity(intent2);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
