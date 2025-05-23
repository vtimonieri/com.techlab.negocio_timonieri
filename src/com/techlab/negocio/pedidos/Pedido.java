package com.techlab.negocio.pedidos;

import java.util.ArrayList;
import java.util.List;

import com.techlab.negocio.producto.Producto;
import com.techlab.negocio.cliente.Cliente;
import com.techlab.negocio.excepciones.StockInsuficienteException;

public class Pedido {
    private static int contadorid=1;
    private static int  contadorPedidos = 0;
    private  int id;
    private ArrayList<LineaPedido> linea = new ArrayList<LineaPedido>();
    private  String  cliente;

//constructor


    public Pedido(int id, ArrayList<LineaPedido> linea, String cliente) {
        this.id = contadorid++;
        this.linea = linea;
        this.cliente = cliente;
    }

    //getter and setter


    public static int getContadorPedidos() {
        return contadorPedidos;
    }

    public int getId() {
        return id;
    }

    public ArrayList<LineaPedido> getLinea() {
        return linea;
    }

    public String getCliente() {
        return cliente;
    }
    //setter


    public void setLinea(ArrayList<LineaPedido> linea) {
        this.linea = linea;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", lineaPedido='" + linea + '\'' +
                ",cliente='"+ cliente+
                '}';
    }

    public void mostrar() {
        System.out.println("ID: " + this.id + " | lineaPedido: " + this.linea + " | cliente:" + this.cliente);
    }

}


