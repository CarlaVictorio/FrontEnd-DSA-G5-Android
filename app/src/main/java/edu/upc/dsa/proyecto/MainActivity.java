package edu.upc.dsa.proyecto;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    TextView textViewRegistrar;
    TextView textViewInicioSesion;
    TextView textViewTitulo;
    TextView textViewErrorInicio; //info errores inicio sesión o registro
    TextView textViewInfoRegister;

    EditText editTextName;
    EditText editTextPassword;

    Button registerBtn;
    Button logInBtn;
    Button volverBtn;
    Button saveBtn;


    public void logInBtn(View v) {

        String user = editTextName.getText().toString();
        String password = editTextPassword.getText().toString();

    }

    public void registerBtn (View v){

        textViewInicioSesion.setVisibility(View.INVISIBLE);
        textViewRegistrar.setVisibility(View.INVISIBLE);
        textViewInfoRegister.setVisibility(View.VISIBLE);
        registerBtn.setVisibility(View.INVISIBLE);
        logInBtn.setVisibility(View.INVISIBLE);
        volverBtn.setVisibility(View.VISIBLE);
        saveBtn.setVisibility(View.VISIBLE);

    }

    public void saveBtn (View v){
        String newUser = editTextName.getText().toString();
        String newPassword = editTextPassword.getText().toString();
    }

    public void volverBtn(View v) {

        textViewInicioSesion.setVisibility(View.VISIBLE);
        textViewRegistrar.setVisibility(View.VISIBLE);
        textViewInfoRegister.setVisibility(View.INVISIBLE);
        registerBtn.setVisibility(View.VISIBLE);
        logInBtn.setVisibility(View.VISIBLE);
        volverBtn.setVisibility(View.INVISIBLE);
        saveBtn.setVisibility(View.INVISIBLE);

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
