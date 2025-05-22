package com.techlab.negocio.excepciones;
import java.lang.Exception;


public class StockInsuficienteException extends Exception {
    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
