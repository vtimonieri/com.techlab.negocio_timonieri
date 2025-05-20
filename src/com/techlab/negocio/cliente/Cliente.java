package com.techlab.negocio.cliente;

public class Cliente {
    private String nombre;
    private String email;

    //constructor con parametros


    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    //getter and setter


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        // Podemos verificar que el nombre no esté vacío
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        // Podemos verificar que el nombre no esté vacío
        if (email != null && !email.trim().isEmpty()) {
            this.email = email;
        }
    }
}



