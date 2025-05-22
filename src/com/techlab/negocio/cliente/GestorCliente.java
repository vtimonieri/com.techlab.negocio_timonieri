package com.techlab.negocio.cliente;
import java.util.ArrayList;
import java.util.List;
import com.techlab.negocio.producto.Producto;

import java.util.ArrayList;

public class GestorCliente {

    static ArrayList<Cliente> listaClientes = new ArrayList<>();
//private List<Cliente> listaClientes = new ArrayList<>();
//metodo agregar clientes
public static Cliente buscarOAgregarCliente(String nombre, String email) {
    for (Cliente cliente : listaClientes) {
        if (cliente.getEmail().equalsIgnoreCase(email) || cliente.getNombre().equalsIgnoreCase(nombre)) {
            System.out.println("Cliente ya existe: " + cliente.getNombre());
            return cliente;
        }
    }

    Cliente nuevoCliente = new Cliente(nombre, email);
    listaClientes.add(nuevoCliente);
    System.out.println("Cliente agregado: " + nombre);
    return nuevoCliente;
}


    public List<Cliente> getClientes() {
            return listaClientes;
        }
    }
