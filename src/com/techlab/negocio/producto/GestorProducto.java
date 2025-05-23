package com.techlab.negocio.producto;
import com.techlab.negocio.excepciones.*;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorProducto {
    //crear un array list para cargar los productos
    private static ArrayList<Producto> catalogo = new ArrayList<>();
    // Scanner para entrada de datos por consola
    static Scanner sc = new Scanner(System.in);


    public static ArrayList<Producto> getCatalogo() {
        return catalogo;
    }
    // Método para crear un nuevo artículo
    public static void crearProducto() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();            // Leer nombre
        String nombreformateado = formatearNombreProducto(nombre);
        System.out.print("Precio: ");
        double precio = sc.nextDouble();          // Leer precio
        sc.nextLine();
        System.out.println("CantidadStock");   // Leer cantidad stock
        int cantidad = sc.nextInt();
        sc.nextLine();

        Producto producto_nuevo = new Producto(nombreformateado, precio, cantidad);
        catalogo.add(producto_nuevo);
        System.out.println(producto_nuevo);
        System.out.println("Producto  agregado.");
    }

    //metodo para formatear el nombre
    //para que no me ingresen cualquier cosa
    public static String formatearNombreProducto(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new NombreProductoInvalidoException("El nombre no puede estar vacío.");
        }

        nombre = nombre.trim().toLowerCase();

        if (!nombre.matches("[a-záéíóúñü\\s]+")) {
            throw new NombreProductoInvalidoException("El nombre solo puede contener letras y espacios.");
        }

        String[] palabras = nombre.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < palabras.length; i++) {
            if (!palabras[i].isEmpty()) {
                String primeraLetra = palabras[i].substring(0, 1).toUpperCase();
                String resto = palabras[i].substring(1);
                sb.append(primeraLetra).append(resto);
                if (i < palabras.length - 1) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
//listar productos

    public static void listarProductos() {
        if (catalogo.isEmpty()) {
            System.out.println("No hay productos en el catálogo.");
        } else {
            for (int i = 0; i < catalogo.size(); i++) {
                catalogo.get(i).mostrar(i + 1);   // Llamada polimórfica al método mostrar()
            }
        }



    }
    public static void modificarProducto(){
        System.out.println("ingrese el nombre del producto a modificar");
        String nombre = sc.nextLine();
        String nombreformateado = formatearNombreProducto(nombre);
        for (Producto producto: catalogo){
           if (producto.getNombre().equals(nombreformateado)){
            sc.nextLine();
         System.out.println("ingrese nuevo nombre:");
             producto.setNombre(sc.nextLine());
                System.out.print("Nuevo precio: ");
                System.out.println("Artículo actualizado.");
                return;
            }
        }
        System.out.println("Artículo no encontrado.");
    }
//eliminar producto

    // Método para eliminar un producto por ID
    public static void eliminarProducto() {
        System.out.print("ID del productoa  eliminar: ");
        int id = sc.nextInt();
        // Usamos removeIf con expresión lambda para eliminar por ID
        catalogo.removeIf(a -> a.getId() == id);
        System.out.println("Producto eliminado si existía.");
    }


}








