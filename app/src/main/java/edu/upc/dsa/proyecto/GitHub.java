package edu.upc.dsa.proyecto;

import java.util.List;

import edu.upc.dsa.proyecto.models.Jugador;
import edu.upc.dsa.proyecto.models.LogIn;
import edu.upc.dsa.proyecto.models.Register;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

public interface GitHub { //MyService

    String URL = "https://147.83.7.207:8080/dsaApp/"; //http://@ip/nombreSwagger

    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> contributors(
            @Path("owner") String owner,
            @Path("repo") String repo);

    @POST("jugador/Login")
    Call<Jugador> logIn(@Body LogIn logIn);

    @POST("jugador/postJugador")
    Call<Jugador> register(@Body Register register);


    Retrofit retrofit = new Retrofit.Builder() //arranco retrofit pero no ejecuto, solo construyo el objeto/clase retrofit
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}