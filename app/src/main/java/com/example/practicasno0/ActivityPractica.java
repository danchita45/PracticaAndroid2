package com.example.practicasno0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ActivityPractica extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica);

        Intent intent = getIntent();
        if (intent != null) {
            String nombre = intent.getStringExtra("nombre");
            String telefono = intent.getStringExtra("telefono");
            String cumple = intent.getStringExtra("cumple");
            String genero = intent.getStringExtra("genero");
            String colores = intent.getStringExtra("colores");

            // Muestra los datos en TextViews u otras vistas en este Activity
            TextView nombreTextView = findViewById(R.id.textViewNombre);
            TextView telefonoTextView = findViewById(R.id.textViewTelefono);
            TextView cumpleTextView = findViewById(R.id.textViewCumple);
            TextView generoTextView = findViewById(R.id.textViewGenero);
            TextView coloresTextView = findViewById(R.id.textViewColores);

            nombreTextView.setText("Nombre: " + nombre);
            telefonoTextView.setText("Teléfono: " + telefono);
            cumpleTextView.setText("Fecha de Cumpleaños: " + cumple);
            generoTextView.setText("Género: " + genero);
            coloresTextView.setText("Colores Preferidos: " + colores);
        }
    }


}