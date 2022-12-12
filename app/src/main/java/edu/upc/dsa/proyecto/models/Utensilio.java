package edu.upc.dsa.proyecto.models;

public class Utensilio {
/*
    public final String nombreUtensilio;
    public Utensilio(String nombreUtensilio) {
        this.nombreUtensilio = nombreUtensilio;

    }
 */
    public String idUtensilio;
    public String nombreUtensilio;
    public double precioUtensilio;
    public int tiempoNivel1;
    public int tiempoNivel2;
    public int tiempoNivel3;

    public Utensilio (String nombreUtensilio, int tiempoNivel1, int tiempoNivel2, int tiempoNivel3, double precioUtensilio) {
        this.setNombreUtensilio(nombreUtensilio);
        this.setTiempoNivel1(tiempoNivel1);
        this.setTiempoNivel2(tiempoNivel2);
        this.setTiempoNivel3(tiempoNivel3);
        this.setPrecioUtensilio(precioUtensilio);
    }

    public String getIdUtensilio() {
        return idUtensilio;
    }

    public void setIdUtensilio(String idUtensilio) {
        this.idUtensilio = idUtensilio;
    }

    public String getNombreUtensilio() {
        return nombreUtensilio;
    }

    public void setNombreUtensilio(String nombreUtensilio) {
        this.nombreUtensilio = nombreUtensilio;
    }

    public int getTiempoNivel1() {
        return tiempoNivel1;
    }

    public void setTiempoNivel1(int tiempoNivel1) {
        this.tiempoNivel1 = tiempoNivel1;
    }

    public int getTiempoNivel2() {
        return tiempoNivel2;
    }

    public void setTiempoNivel2(int tiempoNivel2) {
        this.tiempoNivel2 = tiempoNivel2;
    }

    public int getTiempoNivel3() {
        return tiempoNivel3;
    }

    public void setTiempoNivel3(int tiempoNivel3) {
        this.tiempoNivel3 = tiempoNivel3;
    }

    public double getPrecioUtensilio() {
        return precioUtensilio;
    }

    public void setPrecioUtensilio(double precioUtensilio) {
        this.precioUtensilio = precioUtensilio;
    }

}
