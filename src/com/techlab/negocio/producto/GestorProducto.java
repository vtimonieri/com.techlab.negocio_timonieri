package com.techlab.negocio.producto;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorProducto {
    //crear un array list para cargar los productos


    static ArrayList<Producto> catalogo = new ArrayList<>();
    // Scanner para entrada de datos por consola
    static Scanner sc = new Scanner(System.in);

    //metodos utilizados para productos
//para crear productos
    public static void crearProducto() {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();     // Leer ID
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();            // Leer nombre
        System.out.print("Precio: ");
        double precio = sc.nextDouble();          // Leer precio
        System.out.println("CantidadEnStock: ");
        int cantidadEnStock = sc.nextInt();

        // Crear un nuevo objeto Producto y agregarlo a la lista
        Producto nuevo_producto = new Producto(id,nombre,precio,cantidadEnStock);
        catalogo.add(nuevo_producto);
        System.out.println("Producto ingresado.");
    }

    //metodo para mostrar


    //para listar productos
    public static void listarProducto() {
        if (catalogo.isEmpty()) {
            System.out.println("No hay productos para mostrar.");
        } else {
            for (Producto a : catalogo) {
                a.mostrar();   // Llamada polimórfica al método mostrar()
            }
        }
    }

    //para modificar productos

    public static void modificarProducto() {
        System.out.print("ID del producto a modificar: ");
        int id = sc.nextInt();
        for (Producto producto : catalogo) {
            if (producto.getId() == id) {
                sc.nextLine();
                System.out.print("Nuevo nombre: ");
                producto.setNombre(sc.nextLine());       // Usar setter para cambiar nombre
                System.out.print("Nuevo precio: ");
                producto.setPrecio(sc.nextDouble());
                // Usar setter para cambiar precio
                System.out.println("Producto actualizado.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    //para eliminar producto
    public static void eliminarProducto() {
        System.out.print("ID del producto a eliminar: ");
        int id = sc.nextInt();
        // Usamos removeIf con expresión lambda para eliminar por ID
        catalogo.removeIf(a -> a.getId() == id);
        System.out.println("Producto  eliminado si existía.");
    }





}
