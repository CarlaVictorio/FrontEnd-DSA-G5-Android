package edu.upc.dsa.proyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import edu.upc.dsa.proyecto.api.Client;
import edu.upc.dsa.proyecto.api.CookWithMeAPI;

public class MainActivity extends AppCompatActivity {

    Button salirBtn, ingredientesBtn, utensiliosBtn;
    TextView textViewNombre;
    CookWithMeAPI gitHub;
    String nombre;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    private static final String SHARED_PREF_NAME = "datosLogIn";
    private static final String KEY_NOMBRE = "nombre";
    //private static final String KEY_ACTIVO = "activo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salirBtn = (Button)findViewById(R.id.salirBtn);
        ingredientesBtn = (Button)findViewById(R.id.ingredientesBtn);
        utensiliosBtn = (Button)findViewById(R.id.utensiliosBtn);
        textViewNombre = (TextView)findViewById(R.id.textViewNombre);
        gitHub= Client.getClient().create(CookWithMeAPI.class);

        sharedPref = getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        //Boolean activo = sharedPref.getBoolean(KEY_ACTIVO,false);
        nombre = sharedPref.getString(KEY_NOMBRE,null);
        String texto="Bienvenid@ " + nombre;
        textViewNombre.setText(texto);


    }

    public void salirBtn(View v){
        editor.clear();
        editor.commit();
        Intent login= new Intent (MainActivity.this, LogInActivity.class);
        startActivity(login);
    }

    public void ingredientesBtn(View v){
        Intent tienda1= new Intent (MainActivity.this, IngredientesActivity.class);
        startActivity(tienda1);
    }
    public void utensiliosBtn(View v){
        Intent tienda2= new Intent (MainActivity.this, UtensiliosActivity.class);
        startActivity(tienda2);
    }

}