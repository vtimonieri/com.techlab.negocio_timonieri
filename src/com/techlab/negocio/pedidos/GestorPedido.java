package com.techlab.negocio.pedidos;

import com.techlab.negocio.cliente.Cliente;
import com.techlab.negocio.excepciones.StockInsuficienteException;
import com.techlab.negocio.producto.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GestorPedido {

    private List<Producto> productosDisponibles = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Pedido> pedidosRealizados = new ArrayList<>();

    public GestorPedido() {
        inicializarProductos();
        inicializarClientes();
    }

    private void inicializarProductos() {
        productosDisponibles.add(new Producto("Collar", 1200, 10));
        productosDisponibles.add(new Producto("Correa", 1800, 5));
        productosDisponibles.add(new Producto("Comedero", 900, 8));
    }

    private void inicializarClientes() {
        clientes.add(new Cliente("Juan Perez", "juan@mail.com"));
        clientes.add(new Cliente("Ana Gomez", "ana@mail.com"));
    }

    public void crearPedido() {
        Scanner scanner = new Scanner(System.in);

        Cliente cliente = buscarOCrearCliente(scanner);
        Pedido pedido = new Pedido(cliente);

        boolean continuar = true;

        while (continuar) {
            Producto producto = buscarProductoPorIdONombre(scanner);
            if (producto == null) {
                System.out.println("Producto no encontrado.");
                continue;
            }

            System.out.println("Ingrese cantidad:");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            try {
                pedido.agregarProducto(producto, cantidad);
                System.out.println("Producto agregado correctamente.");
            } catch (StockInsuficienteException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("¿Desea agregar otro producto? (s/n)");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }


        // Confirmación final
        System.out.println("\n¿Desea confirmar el pedido? (s/n)");
        String confirmacion = scanner.nextLine();
        if (confirmacion.equalsIgnoreCase("s")) {
            pedidosRealizados.add(pedido);
            System.out.println("Pedido confirmado con ID: " + pedido.getId());
        } else {
            System.out.println("Pedido cancelado.");
        }
    }

    private Cliente buscarOCrearCliente(Scanner scanner) {
        System.out.println("¿Desea buscar cliente por (1) ID o (2) Nombre?");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        Cliente clienteEncontrado = null;

        if (opcion == 1) {
            System.out.println("Ingrese ID del cliente:");
            long id = scanner.nextLong();
            scanner.nextLine();
            for (Cliente c : clientes) {
                if (c.getId() == id) {
                    clienteEncontrado = c;
                    break;
                }
            }
        } else {
            System.out.println("Ingrese nombre del cliente:");
            String nombre = scanner.nextLine();
            for (Cliente c : clientes) {
                if (c.getNombre().equalsIgnoreCase(nombre)) {
                    clienteEncontrado = c;
                    break;
                }
            }
        }

        if (clienteEncontrado == null) {
            System.out.println("Cliente no encontrado. ¿Desea agregarlo? (s/n)");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                System.out.println("Ingrese nombre:");
                String nombre = scanner.nextLine();
                System.out.println("Ingrese email:");
                String email = scanner.nextLine();
                clienteEncontrado = new Cliente(nombre, email);
                clientes.add(clienteEncontrado);
                System.out.println("Cliente agregado.");
            } else {
                System.out.println("No se puede continuar sin un cliente.");
                return buscarOCrearCliente(scanner); // reintentar
            }
        }
        if (clienteEncontrado != null) {
            System.out.println("Datos del cliente:");
            System.out.println("ID: " + clienteEncontrado.getId());
            System.out.println("Nombre: " + clienteEncontrado.getNombre());
            System.out.println("Precio: $" +clienteEncontrado.getEmail());

        }

        return clienteEncontrado;
    }

    private Producto buscarProductoPorIdONombre(Scanner scanner) {
        System.out.println("¿Desea buscar producto por (1) ID o (2) Nombre?");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        Producto productoEncontrado = null;

        if (opcion == 1) {
            System.out.println("Ingrese ID del producto:");
            long id = scanner.nextLong();
            scanner.nextLine();
            productoEncontrado = buscarProductoPorId(id);
        } else {
            System.out.println("Ingrese nombre del producto:");
            String nombre = scanner.nextLine();
            for (Producto p : productosDisponibles) {
                if (p.getNombre().equalsIgnoreCase(nombre)) {
                    productoEncontrado = p;
                    break;
                }
            }
        }

        if (productoEncontrado != null) {
            System.out.println("Producto encontrado:");
            System.out.println("ID: " + productoEncontrado.getId());
            System.out.println("Nombre: " + productoEncontrado.getNombre());
            System.out.println("Precio: $" + productoEncontrado.getPrecio());
            System.out.println("Stock disponible: " + productoEncontrado.getCantidadEnStock());
        }

        return productoEncontrado;
    }

    private Producto buscarProductoPorId(long id) {
        for (Producto p : productosDisponibles) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void mostrarProductos() {
        System.out.println("Productos disponibles:");
        for (Producto p : productosDisponibles) {
            System.out.println("ID: " + p.getId());
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Precio: $" + p.getPrecio());
            System.out.println("Stock: " + p.getCantidadEnStock());
            System.out.println("----------------------");
        }
    }


    //para listar pedidos

    public  void listarPedidos() {
        if (pedidosRealizados.isEmpty()) {
            System.out.println("No hay pedidos  para mostrar.");
        } else {
            for (Pedido a : pedidosRealizados) {
                a.mostrar();   // Llamada polimórfica al método mostrar()
            }
        }
    }

    public void mostrarClientes() {
        System.out.println("Clientes registrados:");
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
}