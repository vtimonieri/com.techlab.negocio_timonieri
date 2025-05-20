package com.techlab.negocio.producto;

public class Producto {
    // Atributos privados para aplicar el principio de encapsulamiento
    private int id;
    private String nombre;
    private double precio;
    private int cantidadEnStock;

//constructor con parametros


    public Producto(int id, String nombre, double precio, int cantidadEnStock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
    }

    public int getId() {
        return id;
    }

   // public void setId(int id) {
   //     this.id = id;
   // }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        // Podemos verificar que el nombre no esté vacío
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    public double getPrecio() {

        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        }

    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        if (cantidadEnStock >= 0) {
            this.cantidadEnStock = cantidadEnStock;
        }
    }

    //metodo mostrar

    // Método para mostrar la información del artículo
    public void mostrar() {
        // Este método puede ser sobrescrito por subclases (polimorfismo)
        System.out.println("ID: " + id + " | Nombre: " + nombre + " | Precio: $" + precio + " | Stock: " + cantidadEnStock);
    }
}

