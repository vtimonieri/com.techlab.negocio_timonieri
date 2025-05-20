package com.techlab.negocio;
import java.util.Scanner;
import com.techlab.negocio.producto.Producto;
import static com.techlab.negocio.producto.GestorProducto.*;
public class Main {
    public static void main(String[] args) {
        // Scanner para entrada de datos por consola
        Scanner sc = new Scanner(System.in);


        int opcion;
        // Bucle principal del programa con menú interactivo
        do {
            System.out.println("\n--- Menú de Artículos ---");
            System.out.println("1. Crear artículo");
            System.out.println("2. Listar artículos");
            System.out.println("3. Modificar artículo");
            System.out.println("4. Eliminar artículo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();         // Leer opción del usuario
            sc.nextLine();                 // Limpiar buffer del scanner

            // Estructura switch para manejar las opciones
            switch (opcion) {
                case 1 -> crearProducto();
                case 2 -> listarProducto();
                case 3 -> modificarProducto();
                case 4 -> eliminarProducto();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 5); // Repetir hasta que el usuario elija salir
    }
}

