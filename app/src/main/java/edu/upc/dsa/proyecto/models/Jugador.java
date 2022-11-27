package edu.upc.dsa.proyecto.models;


public class Jugador {


        String id;
        String nombre;
        String password;

        public Jugador() {

        }

        public Jugador (String nombre, String password) {
            this();
            this.setNombre(nombre);
            this.setPassword(password);
        }

        public String  getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password
        ) {
            this.password = password;
        }
}

