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
    public void crearProducto() {
        //System.out.print("ID: ");
        //int id = sc.nextInt(); sc.nextLine();     // Leer ID
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();            // Leer nombre
        String nombreformateado = formatearNombreProducto(nombre);

        System.out.println("Precio: ");
        double precio = sc.nextDouble();          // Leer precio
        System.out.println("CantidadEnStock: ");
        int cantidadEnStock = sc.nextInt();

        // Crear un nuevo objeto Producto y agregarlo a la lista
        Producto nuevo_producto = new Producto(nombre,precio,cantidadEnStock);
        catalogo.add(nuevo_producto);
        System.out.println("Producto ingresado.");
        System.out.println(nuevo_producto);
    }

    //metodo para mostrar


    //para listar productos
    public  void listarProducto() {
        if (catalogo.isEmpty()) {
            System.out.println("No hay productos para mostrar.");
        } else {
            for (Producto a : catalogo) {
                a.mostrar();   // Llamada polimórfica al método mostrar()
            }
        }
    }

    //buscar actualizar producto

    public  void buscarProducto() {
        System.out.println("\n📦 ¿Cómo desea buscar el producto?");
        System.out.println("1. Por ID");
        System.out.println("2. Por nombre");
        System.out.println("3. Cancelar");

        String opcionBusqueda = sc.nextLine();

        String criterio = null;
        switch (opcionBusqueda) {
            case "1":
                System.out.print("Ingrese el ID del producto: ");
                criterio = sc.nextLine();
                break;
            case "2":
                System.out.print("Ingrese el nombre del producto: ");
                criterio = sc.nextLine();
                break;
            case "3":
                System.out.println("🔙 Operación cancelada.");
                return;
            default:
                System.out.println("❌ Opción inválida.");
                return;
        }

        Producto productoEncontrado = null;

        try {
            long id = Long.parseLong(criterio);
            for (Producto a : catalogo) {
                if (a.getId() == id) {
                    productoEncontrado = a;
                    break;
                }
            }
            if (productoEncontrado == null) {
                System.out.println("❌ No se encontró un producto con el ID: " + id);
                return;
            }
        } catch (NumberFormatException e) {
            for (Producto a : catalogo) {
                if (a.getNombre().equalsIgnoreCase(criterio.trim())) {
                    productoEncontrado = a;
                    break;
                }
            }
            if (productoEncontrado == null) {
                System.out.println("❌ No se encontró un producto con el nombre: " + criterio);
                return;
            }
        }

        System.out.println("✅ Producto encontrado:");
        System.out.println(productoEncontrado);

        System.out.print("¿Desea actualizar precio, stock o ambos? (1=Precio, 2=Stock, 3=Ambos, otro=nada): ");
        String opcion = sc.nextLine();

        switch (opcion) {
            case "1":
                confirmarYActualizarPrecio(productoEncontrado, sc);
                break;
            case "2":
                confirmarYActualizarStock(productoEncontrado, sc);
                break;
            case "3":
                confirmarYActualizarPrecio(productoEncontrado, sc);
                confirmarYActualizarStock(productoEncontrado, sc);
                break;
            default:
                System.out.println("No se realizó ninguna actualización.");
                return;
        }

        System.out.println("\n✅ Producto actualizado:");
        System.out.println(productoEncontrado);
    }

    private  void confirmarYActualizarPrecio(Producto producto, Scanner scanner) {
        System.out.print("Ingrese el nuevo precio: ");
        try {
            double nuevoPrecio = Double.parseDouble(scanner.nextLine());
            if (nuevoPrecio < 0) {
                System.out.println("❌ El precio no puede ser negativo.");
                return;
            }

            System.out.print("¿Confirmar cambio de precio a $" + nuevoPrecio + "? (sí/no): ");
            String confirmacion = scanner.nextLine();
            if (confirmacion.equalsIgnoreCase("sí")) {
                producto.setPrecio(nuevoPrecio);
                System.out.println("Precio actualizado correctamente.");
            } else {
                System.out.println("❌ Precio no modificado.");
            }

        } catch (NumberFormatException ex) {
            System.out.println("❌ Precio inválido.");
        }
    }

    private void confirmarYActualizarStock(Producto producto, Scanner scanner) {
        System.out.print("Ingrese el nuevo stock: ");
        try {
            int nuevoStock = Integer.parseInt(scanner.nextLine());
            if (nuevoStock < 0) {
                System.out.println("❌ El stock no puede ser negativo.");
                return;
            }

            System.out.print("¿Confirmar cambio de stock a " + nuevoStock + " unidades? (sí/no): ");
            String confirmacion = scanner.nextLine();
            if (confirmacion.equalsIgnoreCase("sí")) {
                producto.setCantidadEnStock(nuevoStock);
                System.out.println("Stock actualizado correctamente.");
            } else {
                System.out.println("❌ Stock no modificado.");
            }

        } catch (NumberFormatException ex) {
            System.out.println("❌ Stock inválido.");
        }
    }



    //para eliminar producto
    public  void eliminarProducto() {


        if (catalogo.isEmpty()) {
            System.out.println("📭 No hay productos en el catálogo.");
            return;
        }

        System.out.println("¿Cómo desea identificar el producto a eliminar?");
        System.out.println("1. Por ID");
        System.out.println("2. Por posición en la lista");
        System.out.println("3. Ver catálogo y elegir");
        System.out.print("Ingrese opción (1-3): ");
        String opcion = sc.nextLine();

        Producto productoAEliminar = null;
        int indice = -1;

        switch (opcion) {
            case "1":
                System.out.print("Ingrese el ID del producto: ");
                try {
                    long id = Long.parseLong(sc.nextLine());
                    for (int i = 0; i < catalogo.size(); i++) {
                        if (catalogo.get(i).getId() == id) {
                            productoAEliminar = catalogo.get(i);
                            indice = i;
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ ID inválido.");
                    return;
                }
                break;

            case "2":
                System.out.print("Ingrese la posición del producto (comienza en 0): ");
                try {
                    indice = Integer.parseInt(sc.nextLine());
                    if (indice >= 0 && indice < catalogo.size()) {
                        productoAEliminar = catalogo.get(indice);
                    } else {
                        System.out.println("❌ Posición fuera de rango.");
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Posición inválida.");
                    return;
                }
                break;

            case "3":
                System.out.println("\n📦 Catálogo actual:");
                for (int i = 0; i < catalogo.size(); i++) {
                    Producto p = catalogo.get(i);
                    System.out.printf("[%d] ID: %d | Nombre: %s | Precio: %.2f | Stock: %d\n",
                            i, p.getId(), p.getNombre(), p.getPrecio(), p.getCantidadEnStock());
                }
                System.out.print("Ingrese el número de posición del producto a eliminar: ");
                try {
                    indice = Integer.parseInt(sc.nextLine());
                    if (indice >= 0 && indice < catalogo.size()) {
                        productoAEliminar = catalogo.get(indice);
                    } else {
                        System.out.println("❌ Posición fuera de rango.");
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Entrada inválida.");
                    return;
                }
                break;

            default:
                System.out.println("❌ Opción no válida.");
                return;
        }

        if (productoAEliminar != null) {
            System.out.println("\n🟠 Producto seleccionado:");
            System.out.println(productoAEliminar);
            System.out.print("¿Está seguro que desea eliminar este producto? (sí/no): ");
            String confirmacion = sc.nextLine();
            if (confirmacion.equalsIgnoreCase("sí")) {
                catalogo.remove(indice);
                System.out.println("✅ Producto eliminado correctamente.");
                Producto.disminuirContadorProductos();
            } else {
                System.out.println("❌ Eliminación cancelada.");
            }
        } else {
            System.out.println("❌ No se encontró el producto.");
        }
    }

//para formatear los nombres que se ingresesn
public  String formatearNombreProducto(String nombre) {

    if (nombre == null || nombre.trim().isEmpty()) {
        throw new IllegalArgumentException("El nombre no puede estar vacío.");
    }

    nombre = nombre.trim().toLowerCase();

    //para que no me ingresen cualquier cosa

    if (!nombre.matches("[a-záéíóúñü\\s]+")) {
        throw new IllegalArgumentException("El nombre solo puede contener letras y espacios.");
    }


// Dividimos en palabras
    String[] palabras = nombre.split(" ");
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < palabras.length; i++) {
        if (!palabras[i].isEmpty()) {
            String primeraLetra =
                    palabras[i].substring(0,1).toUpperCase();
            String resto = palabras[i].substring(1);
            sb.append(primeraLetra).append(resto);
            if (i < palabras.length - 1) {
                sb.append(" ");
            }
        }
    }
    return sb.toString();
}




}
