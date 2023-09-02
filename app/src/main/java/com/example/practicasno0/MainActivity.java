package com.example.practicasno0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.Normalizer;

public class MainActivity extends AppCompatActivity {

    EditText etNombre,etPassword;
    Button btnCerrar,btnAccesar,btnNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(MainActivity.this,"estamos en onCreate",Toast.LENGTH_SHORT).show();

        btnAccesar = findViewById(R.id.accesarMain);
        btnCerrar = findViewById(R.id.cerrarMain);
        btnNuevo = findViewById(R.id.segundoActi);

        btnAccesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"accesando",Toast.LENGTH_SHORT).show();
                Intent FormIntent = new Intent(view.getContext(),Formulario.class);
                startActivity(FormIntent);

            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Saliendo",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent FormIntent = new Intent(view.getContext(),ActivityPractica.class);
                startActivity(FormIntent);

            }
        });


    }

    @Override
    protected  void onStart(){
        super.onStart();
        //Toast.makeText(MainActivity.this,"estamos en onStart",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected  void onResume(){
        super.onResume();
        //Toast.makeText(MainActivity.this,"estamos en onResume",Toast.LENGTH_SHORT).show();

    }


    @Override
    protected  void onPause(){
        super.onPause();
        //Toast.makeText(MainActivity.this,"estamos en onPause",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected  void onStop(){
        super.onStop();
        //Toast.makeText(MainActivity.this,"estamos en onStop",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onDestroy(){
        super.onDestroy();
        //Toast.makeText(MainActivity.this,"estamos en onDestroy",Toast.LENGTH_SHORT).show();
    }
}