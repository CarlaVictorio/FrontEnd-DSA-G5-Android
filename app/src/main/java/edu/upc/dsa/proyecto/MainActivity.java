package edu.upc.dsa.proyecto;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.upc.dsa.proyecto.models.Jugador;
import edu.upc.dsa.proyecto.models.LogIn;
import edu.upc.dsa.proyecto.models.Register;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    TextView textViewRegister;
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

    GitHub gitHub;
    SharedPreferences.Editor editor;


    public void logInBtn(View v) {

        String user = editTextName.getText().toString();
        String password = editTextPassword.getText().toString();

        gitHub.logIn(new LogIn(user,password)).enqueue(new Callback<Jugador>() {
            @Override
            public void onResponse(Call<Jugador> call, Response<Jugador> response) {
                Log.d("Correcto",""+response.code());
                String respuesta = Integer.toString(response.code());
                if(response.isSuccessful()){
                    editor.putString("User: ", user);
                    editor.putString("Password: ", password);
                    editor.putBoolean("logged", true);
                    editor.apply();
                }
                Toast.makeText(getApplicationContext(),respuesta +": " + response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Jugador> call, Throwable t) {
                Log.d("Fail", " "+t.getMessage());
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void registerBtn (View v){



        textViewInicioSesion.setVisibility(View.INVISIBLE);
        textViewRegister.setVisibility(View.INVISIBLE);
        textViewInfoRegister.setVisibility(View.VISIBLE);
        registerBtn.setVisibility(View.INVISIBLE);
        logInBtn.setVisibility(View.INVISIBLE);
        volverBtn.setVisibility(View.VISIBLE);
        saveBtn.setVisibility(View.VISIBLE);

    }

    public void saveBtn (View v){
        String newUser = editTextName.getText().toString();
        String newPassword = editTextPassword.getText().toString();

        textViewInicioSesion.setVisibility(View.VISIBLE);
        textViewRegister.setVisibility(View.VISIBLE);
        textViewInfoRegister.setVisibility(View.INVISIBLE);
        registerBtn.setVisibility(View.VISIBLE);
        logInBtn.setVisibility(View.VISIBLE);
        volverBtn.setVisibility(View.INVISIBLE);
        saveBtn.setVisibility(View.INVISIBLE);


        gitHub.register(new Register(newUser,newPassword)).enqueue(new Callback<Jugador>() {
            @Override
            public void onResponse(Call<Jugador> call, Response<Jugador> response) {
                Log.d("Correcto",""+response.code());
                String respuesta = Integer.toString(response.code());
                if(response.isSuccessful()){
                    editor.putString("User: ", newUser);
                    editor.putString("Password: ", newPassword);
                    editor.apply();
                }
                Toast.makeText(getApplicationContext(),respuesta +": " + response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Jugador> call, Throwable t) {
                Log.d("Fail", " " + t.getMessage());
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void volverBtn(View v) {

        textViewInicioSesion.setVisibility(View.VISIBLE);
        textViewRegister.setVisibility(View.VISIBLE);
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
        textViewInfoRegister = (TextView)findViewById(R.id.textViewInfoRegister);
        textViewInicioSesion = (TextView)findViewById(R.id.textViewInicioSesion);
        textViewErrorInicio = (TextView)findViewById(R.id.textViewErrorInicio);
        textViewTitulo = (TextView)findViewById(R.id.textViewTitulo);
        textViewRegister = (TextView)findViewById(R.id.textViewRegister);

        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);

        registerBtn = (Button)findViewById(R.id.registerBtn);
        logInBtn=(Button)findViewById(R.id.logInBtn);
        volverBtn=(Button)findViewById(R.id.volverBtn);
        saveBtn=(Button)findViewById(R.id.saveBtn);
    }


}

