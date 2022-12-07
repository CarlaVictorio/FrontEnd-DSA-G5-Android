package edu.upc.dsa.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.upc.dsa.proyecto.api.Client;
import edu.upc.dsa.proyecto.api.CookWithMeAPI;

public class TiendaActivity extends AppCompatActivity {

    CookWithMeAPI gitHub;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gitHub= Client.getClient().create(CookWithMeAPI.class);
    }

    public void volverBtn(View v){
        Intent main= new Intent (TiendaActivity.this, MainActivity.class);
        startActivity(main);
    }



}