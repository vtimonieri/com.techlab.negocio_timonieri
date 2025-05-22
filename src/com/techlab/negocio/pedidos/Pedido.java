package com.techlab.negocio.pedidos;

import java.util.ArrayList;
import java.util.List;

import com.techlab.negocio.producto.Producto;
import com.techlab.negocio.cliente.Cliente;
import com.techlab.negocio.excepciones.StockInsuficienteException;

public class Pedido {
    private static long contadorId = 1;
    private static int contadorPedidos = 0;
    private long id;
    private List<LineaPedido> lineas;
    private Cliente cliente;

    public Pedido(Cliente cliente) {
        this.id = contadorId++;
        this.lineas = new ArrayList<>();
        this.cliente = cliente;

        contadorPedidos++; // Se cuenta el producto creado


    }

    //getter y setter


    public  long getId() {
        return id;
    }

    public static int getContadorPedidos() {
        return contadorPedidos;
    }

    public List<LineaPedido> getLineas() {
        return lineas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void agregarProducto(Producto producto, int cantidad) throws StockInsuficienteException {
        if (cantidad > producto.getCantidadEnStock()) {
            throw new StockInsuficienteException("Stock insuficiente para el producto: " + producto.getNombre());
        }
        lineas.add(new LineaPedido(producto, cantidad));
        producto.reducirStock(cantidad); // este método lo podés agregar en Producto
    }

    public double calcularTotal() {
        double total = 0;
        for (LineaPedido linea : lineas) {
            total += linea.calcularSubtotal();
        }
        return total;
    }
    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", lineapedido=" + lineas +
                '}';
    }

    public void mostrar() {
        System.out.println("ID: " + id + " | cliente: " + cliente + " | lineapedido: " + lineas);
    }






}

