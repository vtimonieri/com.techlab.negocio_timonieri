package com.techlab.negocio.excepciones;


    public class NombreProductoInvalidoException extends IllegalArgumentException {
        public NombreProductoInvalidoException(String mensaje) {
            super(mensaje);
        }
    }