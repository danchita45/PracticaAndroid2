package com.example.practicasno0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Formulario extends AppCompatActivity {


    private EditText nombreEditText;
    private EditText telefonoEditText;
    private EditText cumpleEditText;
    private RadioGroup generoRadioGroup;
    private CheckBox[] coloresCheckBoxes;
    Button camara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);


        camara  = findViewById(R.id.btnCamara);
        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a  = new Intent(Formulario.this , Camara.class );
                startActivity(a);

            }
        });
        nombreEditText = findViewById(R.id.editTextNombre);
        telefonoEditText = findViewById(R.id.editTextTelefono);
        cumpleEditText = findViewById(R.id.editTextCumple);
        generoRadioGroup = findViewById(R.id.radioGroupGenero);
        coloresCheckBoxes = new CheckBox[]{
                findViewById(R.id.checkBoxRojo),
                findViewById(R.id.checkBoxVerde),
                findViewById(R.id.checkBoxAmarillo),
                findViewById(R.id.checkBoxMorado),
                findViewById(R.id.checkBoxAzul)
        };
        Button btnMostrar = findViewById(R.id.btnFormMostrar);
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarInformacion();
            }
        });


    }
    private void mostrarInformacion() {
        // Captura los valores ingresados por el usuario
        String nombre = nombreEditText.getText().toString();
        String telefono = telefonoEditText.getText().toString();
        String cumple = cumpleEditText.getText().toString();

        RadioButton radioButton = findViewById(generoRadioGroup.getCheckedRadioButtonId());
        String genero = radioButton.getText().toString();

        StringBuilder colores = new StringBuilder();
        for (CheckBox checkBox : coloresCheckBoxes) {
            if (checkBox.isChecked()) {
                colores.append(checkBox.getText()).append(", ");
            }
        }
        // Elimina la última coma y espacio si hay colores seleccionados
        if (colores.length() > 0) {
            colores.delete(colores.length() - 2, colores.length());
        }

        // Crea un Intent para pasar datos al segundo Activity
        Intent intent = new Intent(this, ActivityPractica.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("telefono", telefono);
        intent.putExtra("cumple", cumple);
        intent.putExtra("genero", genero);
        intent.putExtra("colores", colores.toString());

        // Inicia el segundo Activity
        startActivity(intent);
    }
}