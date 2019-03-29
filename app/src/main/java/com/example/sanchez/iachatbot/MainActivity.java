package com.example.sanchez.iachatbot;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewUser;
    private RecyclerViewAdapter adapterUser;

    EditText txtTexto;
    Button btnEnviar;
    List<UserModelo> chat = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTexto = (EditText) findViewById(R.id.txtTexto);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        recyclerViewUser = (RecyclerView) findViewById(R.id.recyclerUser);
        recyclerViewUser.setLayoutManager(new LinearLayoutManager(this));
        adapterUser = new RecyclerViewAdapter(obtenerTexto(txtTexto.toString()));

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtTexto.getText().toString().toLowerCase().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "¡Ingresa texto por favor!", Toast.LENGTH_SHORT).show();
                }else {
                    chat.add(new UserModelo("Human:", txtTexto.getText().toString(), R.drawable.girl));

                    if(txtTexto.getText().toString().toLowerCase().trim().equals("hola")){
                        chat.add(new UserModelo("Machine:","Hola!",R.drawable.man));

                    }else if(txtTexto.getText().toString().toLowerCase().equals("buen dia") ||
                            txtTexto.getText().toString().toLowerCase().trim().equals("buen día")){
                        chat.add(new UserModelo("Machine:","Hola, buen día!",R.drawable.man));

                    }else if(txtTexto.getText().toString().equals("como esta") ||
                            txtTexto.getText().toString().equals("como esta?") ||
                            txtTexto.getText().toString().equals("como está?") ||
                            txtTexto.getText().toString().equals("como está") ||
                            txtTexto.getText().toString().equals("como estás?") ||
                            txtTexto.getText().toString().equals("como está") ||
                            txtTexto.getText().toString().equals("como estas") ){
                        chat.add(new UserModelo("Machine:","Bien y tu?",R.drawable.man));

                    }else if(txtTexto.getText().toString().toLowerCase().trim().equals("profesor")){
                        chat.add(new UserModelo("Machine:","Digame!",R.drawable.man));

                    }else if(txtTexto.getText().toString().toLowerCase().trim().equals("habra clases manana") ||
                            txtTexto.getText().toString().toLowerCase().equals("habra clases mañana")  ||
                            txtTexto.getText().toString().toLowerCase().equals("habra clases mañana?") ||
                            txtTexto.getText().toString().toLowerCase().equals("habrá clases mañana?") ){
                        chat.add(new UserModelo("Machine:","si, por supuesto que si.",R.drawable.man));

                    }else if(txtTexto.getText().toString().toLowerCase().equals("cuando habra examen") ||
                            txtTexto.getText().toString().toLowerCase().equals("cuándo habra examen") ||
                            txtTexto.getText().toString().toLowerCase().equals("cuándo habra examen?") ||
                            txtTexto.getText().toString().toLowerCase().equals("cuando habra exámen") ||
                            txtTexto.getText().toString().toLowerCase().equals("cuándo habra exámen") ||
                            txtTexto.getText().toString().toLowerCase().equals("cuándo habra exámen?") ){
                        chat.add(new UserModelo("Machine:","Revise la guia de estudio por favor.",R.drawable.man));

                    }else if(txtTexto.getText().toString().toLowerCase().equals("cuando habra examen") ||
                            txtTexto.getText().toString().toLowerCase().equals("cuando habra examen?") ||
                            txtTexto.getText().toString().toLowerCase().equals("cuándo habra examen") ||
                            txtTexto.getText().toString().toLowerCase().equals("cuándo habra examen?") ||
                            txtTexto.getText().toString().toLowerCase().equals("cuándo habrá examen") ||
                            txtTexto.getText().toString().toLowerCase().equals("cuándo habrá exámen?") ){
                        chat.add(new UserModelo("Machine:","Revise la guia de estudio por favor.",R.drawable.man));

                    }else if(txtTexto.getText().toString().toLowerCase().equals("cuando habrá examen") ||
                            txtTexto.getText().toString().toLowerCase().equals("cuando habrá examen?") ||
                            txtTexto.getText().toString().toLowerCase().equals("cuándo habrá examen") ||
                            txtTexto.getText().toString().toLowerCase().equals("cuándo habrá examen?") ||
                            txtTexto.getText().toString().toLowerCase().equals("cuándo habrá examen") ){
                        chat.add(new UserModelo("Machine:","Revise la guia de estudio por favor.",R.drawable.man));

                    }else if(txtTexto.getText().toString().toLowerCase().equals("a que hora sera el examen") ||
                            txtTexto.getText().toString().toLowerCase().equals("a que hora sera el examen?") ||
                            txtTexto.getText().toString().toLowerCase().equals("a que hora será el examen") ||
                            txtTexto.getText().toString().toLowerCase().equals("a que hora será el examen?") ||
                            txtTexto.getText().toString().toLowerCase().equals("a que hora será el exámen") ||
                            txtTexto.getText().toString().toLowerCase().equals("a que hora será el exámen") ||
                            txtTexto.getText().toString().toLowerCase().equals("a que hora sera el exámen?") ||
                            txtTexto.getText().toString().toLowerCase().equals("a que hora sera el exámen?") ||
                            txtTexto.getText().toString().toLowerCase().equals("a que hora será el exámen?") ){
                        chat.add(new UserModelo("Machine:","El examen será a las 8:00 am en hora de clase",R.drawable.man));

                    }else if(txtTexto.getText().toString().toLowerCase().equals("cuando subira calificaciones") ||
                            txtTexto.getText().toString().toLowerCase().equals("cuando subira calificaciones?") ||
                            txtTexto.getText().toString().toLowerCase().equals("cuando subirá calificaciones") ||
                            txtTexto.getText().toString().toLowerCase().equals("cuando subirá calificaciones?") ||
                            txtTexto.getText().toString().toLowerCase().equals("cuándo subirá calificaciones") ||
                            txtTexto.getText().toString().toLowerCase().equals("cuándo subirá calificaciones?") ){
                        chat.add(new UserModelo("Machine:","Revise sus notas por favor.",R.drawable.man));


                    }else if(txtTexto.getText().toString().toLowerCase().equals("paseme profesor")){
                        chat.add(new UserModelo("Machine:","Estudie!",R.drawable.man));
                    }else if(txtTexto.getText().toString().toLowerCase().equals("paseme profesor")){
                        chat.add(new UserModelo("Machine:","Estudie!",R.drawable.man));
                    }
                }


                recyclerViewUser.setAdapter(adapterUser);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.informacion,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.item1){
            Intent credits = new Intent(this,Credits.class);
            startActivity(credits);

        }
        return super.onOptionsItemSelected(item);
    }

    public List<UserModelo> obtenerTexto(String texto){

        if(texto.equals("Hola")){
            chat.add(new UserModelo("Machine:","Hola!",R.drawable.girl));
        }else if(texto.equals("hola")){
            chat.add(new UserModelo("Machine:","Hola!",R.drawable.girl));
        }else if(texto.equals("Buen dia")){
            chat.add(new UserModelo("Machine:","Hola, buen dia!",R.drawable.girl));
        }else if(texto.equals("buen dia")){
            chat.add(new UserModelo("Machine:","Hola, buen dia!",R.drawable.girl));
        }else if(texto.equals("Como esta?")){
            chat.add(new UserModelo("Machine:","Bien y tu?",R.drawable.girl));
        }else if(texto.equals("como esta?")){
            chat.add(new UserModelo("Machine:","Bien y tu?",R.drawable.girl));
        }else if(texto.equals("Profesor")){
            chat.add(new UserModelo("Machine:","Digame!",R.drawable.girl));
        }else if(texto.equals("profesor")){
            chat.add(new UserModelo("Machine:","Digame!",R.drawable.girl));
        }else if(texto.equals("Cuando es el examen?")){
            chat.add(new UserModelo("Machine:","No habra examen.",R.drawable.girl));
        }else if(texto.equals("cuando es el examen?")){
            chat.add(new UserModelo("Machine:","No habra examen.",R.drawable.girl));
        }else if(texto.equals("Paseme profesor!")){
            chat.add(new UserModelo("Machine:","Estudie!",R.drawable.girl));
        }else if(texto.equals("paseme profesor!")){
            chat.add(new UserModelo("Machine:","Estudie!",R.drawable.girl));
        }

        return chat;
    }
}
