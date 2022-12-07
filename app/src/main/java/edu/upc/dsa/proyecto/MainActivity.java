package edu.upc.dsa.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.upc.dsa.proyecto.api.Client;
import edu.upc.dsa.proyecto.api.CookWithMeAPI;

public class MainActivity extends AppCompatActivity {

    Button salirBtn;
    Button tiendaBtn;
    CookWithMeAPI gitHub;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    private static final String SHARED_PREF_NAME = "datosLogIn";
    private static final String KEY_NOMBRE = "nombre";
    private static final String KEY_ACTIVO = "activo";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salirBtn = (Button)findViewById(R.id.salirBtn);
        tiendaBtn = (Button)findViewById(R.id.tiendaBtn);
        gitHub= Client.getClient().create(CookWithMeAPI.class);

        sharedPref = getSharedPreferences("SHARED_PREF_NAME",Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        Boolean activo = sharedPref.getBoolean(KEY_ACTIVO,false);
    }

    public void salirBtn(View v){
        editor.clear();
        editor.commit();
        Intent login= new Intent (MainActivity.this, LogInActivity.class);
        startActivity(login);

    }

    public void tiendaBtn(View v){
        Intent tienda= new Intent (MainActivity.this, LogInActivity.class);
        startActivity(tienda);

    }

}