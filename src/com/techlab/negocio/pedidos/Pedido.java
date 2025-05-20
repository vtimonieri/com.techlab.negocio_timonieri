package com.techlab.negocio.pedidos;

import java.util.ArrayList;
import com.techlab.negocio.producto.Producto;
import com.techlab.negocio.cliente.Cliente;

public class Pedido {
    private ArrayList<Producto> productos;
    private Cliente cliente;

    //constructores


    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }
    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio() * p.getCantidadEnStock();
        }
        return total;
    }
}