package com.techlab.negocio.cliente;

public class Cliente {

    private int id;
    private String nombre;
    private String email;

    //constructor con parametros

    public Cliente(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }


    //getter and setter


    public long getId() {
        return id;
    }

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




    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ",email='"+ email+
                '}';
    }

    public void mostrar() {
        System.out.println("ID: " + this.id + " | Nombre: " + this.nombre + " | email:" + this.email);
    }

}



