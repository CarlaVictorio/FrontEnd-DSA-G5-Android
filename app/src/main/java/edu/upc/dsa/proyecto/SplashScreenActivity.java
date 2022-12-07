package edu.upc.dsa.proyecto;

import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import edu.upc.dsa.proyecto.models.LogIn;

public class SplashScreenActivity extends AppCompatActivity {

    SharedPreferences sharedPref;
    private static final String SHARED_PREF_NAME = "datosLogIn";
    private static final String KEY_NOMBRE = "nombre";
    private static final String KEY_ACTIVO = "activo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        sharedPref = getSharedPreferences("SHARED_PREF_NAME",Context.MODE_PRIVATE);
        Boolean activo = sharedPref.getBoolean(KEY_ACTIVO,false);

        if (activo==true){
            Toast.makeText(getApplicationContext(),"USUARIO ACTIVO", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SplashScreenActivity.this,MainActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"USUARIO INACTIVO", Toast.LENGTH_SHORT).show();
            Intent intent2 = new Intent(SplashScreenActivity.this, LogInActivity.class);
            startActivity(intent2);
        }
    }






}