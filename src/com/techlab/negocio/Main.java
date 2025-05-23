package com.techlab.negocio;
import com.techlab.negocio.producto.GestorProducto;


import com.techlab.negocio.producto.Producto;

import java.util.ArrayList;
import java.util.Scanner;

import static com.techlab.negocio.pedidos.GestorPedido.hacerPedido;
import static com.techlab.negocio.pedidos.GestorPedido.listarPedido;
import static com.techlab.negocio.producto.GestorProducto.*;

// Clase principal del programa
public class Main {
    // Lista que almacena objetos de tipo producto
    // static ArrayList<Producto> listaproductos = new ArrayList<>();
    // Scanner para entrada de datos por consola
    static Scanner sc = new Scanner(System.in);
    GestorProducto gestorProducto = new GestorProducto();


    // Método principal
    public static void main(String[] args) {
        int opcion;
        // Bucle principal del programa con menú interactivo
        do {
            System.out.println("\n--- Menú TECHLAB ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar artículos");
            System.out.println("3. Modificar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Hacer pedido");
            System.out.println("6. Listar pedidos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();         // Leer opción del usuario
            sc.nextLine();                 // Limpiar buffer del scanner

            // Estructura switch para manejar las opciones
            switch (opcion) {
                case 1 -> crearProducto();
                case 2 -> listarProductos();
                case 3 -> modificarProducto();
                case 4 -> eliminarProducto();
                case 5 -> hacerPedido();
                case 6 -> listarPedido();
                case 7 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 7); // Repetir hasta que el usuario elija salir
    }
}





