package com.example.practicasno0;

import static android.os.Environment.getExternalStoragePublicDirectory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.Manifest;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.security.Permission;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Camara extends AppCompatActivity {
    Button tomar, salir;
    ImageView ivCap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);

        tomar = findViewById(R.id.buttonTomarFoto);
        tomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCaptura(view);
            }
        });
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {

            ivCap = findViewById(R.id.FotoTomada);
        } else {
            // Si los permisos no están otorgados, solicita permisos en tiempo de ejecución
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }


    }

    static final int REQUEST_IMAGE_CAPTURE =1;
    public void mCaptura(View v) {
        Intent PictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (PictureIntent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(PictureIntent,REQUEST_IMAGE_CAPTURE);
        }
    }
    protected void onActivityResult(int RequestCode, int resultCode, Intent data){
        super.onActivityResult(resultCode,resultCode,data);
        if(RequestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extra  = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extra.get("data");
            ivCap.setImageBitmap(imageBitmap);
            try {
                createImageFile();
                gallery();
            }catch (Exception exeption){
                Toast.makeText(Camara.this, "fallo del activity",Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void gallery() {
        Intent mediaIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File safef = new File(currentPhotoPath);
        Uri content = Uri.fromFile(safef);
        mediaIntent.setData(content);
        this.sendBroadcast(mediaIntent);
    }

    String currentPhotoPath;

    private File createImageFile()throws IOException {

            // Crear un nombre de archivo único
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String imageFileName = "JPEG_" + timeStamp + "_";
            File storageDir = getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

            File image = File.createTempFile(
                    imageFileName,  /* prefijo */
                    ".jpg",         /* sufijo */
                    storageDir      /* directorio */
            );

            // Guardar la ruta de la imagen para su uso posterior
            currentPhotoPath = image.getAbsolutePath();
            Toast.makeText(Camara.this, currentPhotoPath,Toast.LENGTH_LONG).show();
            return image;

    }


}