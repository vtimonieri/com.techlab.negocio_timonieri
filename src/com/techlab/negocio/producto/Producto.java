package com.techlab.negocio.producto;


public class Producto {
    private static long contadorId = 1;
    private static int contadorProductos = 0;

    private long id;
    private String nombre;
    private double precio;
    private int cantidadEnStock;

    public Producto(String nombre, double precio, int cantidadEnStock) {
        this.id = contadorId++;; // Se genera ID automáticamente
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;

        contadorProductos++; // Se cuenta el producto creado
    }


    public static int getContadorProductos() {
        return contadorProductos;
    }

    public long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
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

    public static void disminuirContadorProductos() {
        if (contadorProductos > 0) {
            contadorProductos--;
        }
    }

    //para reducir el stock

    public void reducirStock(int cantidad) {
        this.cantidadEnStock -= cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + cantidadEnStock +
                '}';
    }

    public void mostrar() {
        System.out.println("ID: " + id + " | Nombre: " + nombre + " | Precio: $" + precio + " | Stock: " + cantidadEnStock);
    }
}
