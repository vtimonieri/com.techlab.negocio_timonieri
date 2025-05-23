package com.techlab.negocio.producto;


public class Producto {
  private static int contadorid=1;
  private static int contadorProductos = 0;
    private int id;
       private String nombre;
    private double precio;
    private int cantidadEnStock;


    public Producto(String nombre, double precio, int cantidadEnStock) {
        this.id =contadorid++;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;

       // contadorId++;
    }


//getter y setter

    //le hago un get al contador de productos
    // Getter para el atributo id (solo lectura)
    public int getId() {
        return id;
    }

    public static int getContadorProductos() {
        return contadorProductos;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    @Override
    public String toString() {
        return "Producto{+ id =" + id +
                " nombre=" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + cantidadEnStock +
                '}';
    }

    public void reducirStock(int cantidad) {
        if (cantidad > this.cantidadEnStock) {
            throw new RuntimeException("Stock insuficiente para el producto: " + nombre);
        }
        this.cantidadEnStock -= cantidad;
    }


    public void mostrar(int posicion) {
        System.out.println(posicion + ". ID: " + id + " | Nombre: " + nombre + " | Precio: $" + precio + " | Stock: " + cantidadEnStock);
    }

}
