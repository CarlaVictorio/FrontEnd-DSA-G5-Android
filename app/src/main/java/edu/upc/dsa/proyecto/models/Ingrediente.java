package edu.upc.dsa.proyecto.models;

public class Ingrediente {
/*
    public final String nombreIngrediente;
    public Ingrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;

    }
 */
    String idIngrediente;
    public String nombreIngrediente;
    public int nivelDesbloqueoIngrediente;
    public double precioIngrediente;

    public Ingrediente (String nombreIngrediente, int nivelDesbloqueoIngrediente, double precioIngrediente) {
        this.setNombreIngrediente(nombreIngrediente);
        this.setNivelDesbloqueoIngrediente(nivelDesbloqueoIngrediente);
        this.setPrecioIngrediente(precioIngrediente);
    }

    public String getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(String idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public int getNivelDesbloqueoIngrediente() {
        return nivelDesbloqueoIngrediente;
    }

    public void setNivelDesbloqueoIngrediente(int nivelDesbloqueoIngrediente) {
        this.nivelDesbloqueoIngrediente = nivelDesbloqueoIngrediente;
    }

    public double getPrecioIngrediente() {
        return precioIngrediente;
    }

    public void setPrecioIngrediente(double precioIngrediente) {
        this.precioIngrediente = precioIngrediente;
    }

}
