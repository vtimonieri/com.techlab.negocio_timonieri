package com.techlab.negocio.pedidos;

import com.techlab.negocio.producto.Producto;
import com.techlab.negocio.excepciones.StockInsuficienteException;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorPedido {
    private static ArrayList<Pedido> listaPedidos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void hacerPedido() {
        ArrayList<LineaPedido> lineas = new ArrayList<>();
        System.out.print("Nombre del cliente: ");
        String cliente = sc.nextLine();

        boolean seguir = true;

        while (seguir) {
            System.out.print("Ingrese nombre del producto a pedir: ");
            String nombreProducto = sc.nextLine();

            // Acá tendrías que buscar el producto en tu catálogo (suponiendo que tengas acceso a la lista)
            Producto producto = buscarProductoPorNombre(nombreProducto);

            if (producto == null) {
                System.out.println("Producto no encontrado.");
                continue; // vuelve a preguntar
            }

            System.out.print("Cantidad: ");
            int cantidad = sc.nextInt();
            sc.nextLine();

            // Verificamos stock
            if (cantidad > producto.getCantidadEnStock()) {
                System.out.println("Stock insuficiente. Stock actual: " + producto.getCantidadEnStock());
                continue;
            }

            // Reducimos el stock del producto
            producto.reducirStock(cantidad);

            // Creamos la línea de pedido y la agregamos a la lista
            LineaPedido lineaPedido = new LineaPedido(producto, cantidad);
            lineas.add(lineaPedido);

            System.out.print("¿Desea agregar otro producto? (s/n): ");
            String opcion = sc.nextLine();
            if (!opcion.equalsIgnoreCase("s")) {
                seguir = false;
            }
        }

        // Crear el pedido y agregarlo a la lista de pedidos
        Pedido nuevoPedido = new Pedido(0, lineas, cliente);  // El id se asigna automáticamente en el constructor Pedido
        listaPedidos.add(nuevoPedido);

        // Mostrar resumen y total
        System.out.println("Pedido creado exitosamente.");
        nuevoPedido.mostrar();

        double total = calcularTotal(nuevoPedido);
        System.out.println("Total del pedido: $" + total);
    }

    // Método para buscar producto por nombre en el catálogo
    // Para esto necesitás acceso a la lista de productos de GestorProducto (debería ser pública o mediante getter)
    private static Producto buscarProductoPorNombre(String nombre) {
        for (Producto p : com.techlab.negocio.producto.GestorProducto.getCatalogo()) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    private static double calcularTotal(Pedido pedido) {
        double total = 0;
        for (LineaPedido linea : pedido.getLinea()) {
            total += linea.calcularSubtotal();
        }
        return total;
    }

    // Método para listar pedidos guardados
    public static void listarPedido() {
        if (listaPedidos.isEmpty()) {
            System.out.println("No hay pedidos realizados.");
            return;
        }
        for (Pedido pedido : listaPedidos) {
            pedido.mostrar();
        }
    }
}
