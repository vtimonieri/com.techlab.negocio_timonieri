package com.techlab.negocio;


import com.techlab.negocio.pedidos.GestorPedido;
import com.techlab.negocio.producto.GestorProducto;

import java.util.Scanner;



import static com.techlab.negocio.producto.GestorProducto.*;
public class Main {
    public static void main(String[] args) {
        // Scanner para entrada de datos por consola
        Scanner sc = new Scanner(System.in);
        GestorPedido gestorPedido = new GestorPedido();
        GestorProducto gestorProducto = new GestorProducto();

        int opcion;
        // Bucle principal del programa con menú interactivo
        do {
            System.out.println("\n--- Menú TECHLAB ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar/Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Hacer pedido");
            System.out.println("6. Listar pedidos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();         // Leer opción del usuario
            sc.nextLine();                 // Limpiar buffer del scanner

            // Estructura switch para manejar las opciones
            switch (opcion) {
                case 1 -> gestorProducto.crearProducto();
                case 2 -> gestorProducto.listarProducto();
                case 3 -> gestorProducto.buscarProducto();
                case 4 -> gestorProducto.eliminarProducto();
                case 5 -> gestorPedido.crearPedido();
                case 6 -> gestorPedido.listarPedidos();
                case 7 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 5); // Repetir hasta que el usuario elija salir
    }
}

