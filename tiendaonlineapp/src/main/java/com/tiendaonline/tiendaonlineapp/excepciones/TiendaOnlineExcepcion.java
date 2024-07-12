package com.tiendaonline.tiendaonlineapp.excepciones;

public class TiendaOnlineExcepcion extends RuntimeException {
    public TiendaOnlineExcepcion(String message) {
        super(message);
    }

    public TiendaOnlineExcepcion(String message, Throwable cause) {
        super(message, cause);
    }
}
