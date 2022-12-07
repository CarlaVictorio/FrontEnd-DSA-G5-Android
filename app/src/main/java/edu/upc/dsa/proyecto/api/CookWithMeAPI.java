package edu.upc.dsa.proyecto.api;

import edu.upc.dsa.proyecto.models.Jugador;
import edu.upc.dsa.proyecto.models.LogIn;
import edu.upc.dsa.proyecto.models.Register;
import retrofit2.Call;
import retrofit2.http.*;

public interface CookWithMeAPI { //MyService

    String URL = "http://147.83.7.207:8080/"; //http://@ip/nombreSwagger

    @POST("/dsaApp/jugador/Login")
    Call<Void> logIn(@Body LogIn logIn);

    @POST("/dsaApp/jugador/Register")
    Call<Void> register(@Body Register register);


}